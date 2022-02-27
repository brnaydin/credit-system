package com.creditsystem.creditsystem.service.Impl;

import com.creditsystem.creditsystem.enums.CreditResult;
import com.creditsystem.creditsystem.exception.NotFoundException;
import com.creditsystem.creditsystem.model.Application;
import com.creditsystem.creditsystem.model.Customer;
import com.creditsystem.creditsystem.model.Scoring;
import com.creditsystem.creditsystem.repository.ApplicationRepository;
import com.creditsystem.creditsystem.repository.CustomerRepository;
import com.creditsystem.creditsystem.repository.ScoringRepository;
import com.creditsystem.creditsystem.service.ApplicationService;
import com.creditsystem.creditsystem.service.CustomerService;
import com.creditsystem.creditsystem.service.ScoringService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private static final Integer creditLimitFactor = 4;

    private final CustomerRepository customerRepository;
    private final ApplicationRepository applicationRepository;
    private final ScoringRepository scoringRepository;

    @Autowired
    ScoringService scoringService;

    @Autowired
    ApplicationService applicationService;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomer(String tckn) {
        Optional<Customer> customer = customerRepository.findByTckn(tckn);
        return customer.orElseThrow(()->new NotFoundException("Customer"));
    }

    @Override
    public Customer addCustomer(Customer customer) {
        int randomScoring = (int) ((Math.random() * (1400)) + 100);
        scoringRepository.save(new Scoring(customer.getId(),customer.getTckn(),randomScoring ));
        customerRepository.save(customer);
        creditCalculation(customer);
        return customer;
    }

    @Override
    public Customer updateCustomer(String tckn, Customer cs ){
        Customer customer = customerRepository.findByTckn(tckn).orElseThrow(()-> new NotFoundException("Customer"));
        Application application = applicationRepository.findApplicationByTckn(tckn).orElseThrow(()-> new NotFoundException("Application"));
        customer.setId(cs.getId());
        application.setId(customer.getApplication().getId());
        customer.setFullname(cs.getFullname());
        customer.setId(cs.getId());
        customer.setMonthlyIncome(cs.getMonthlyIncome());
        customer.setPhoneNumber(cs.getPhoneNumber());
        customerRepository.save(customer);
        applicationRepository.save(application);
        return customer;
    }

    @Override
    public boolean deleteCustomer(String tckn){
        try {
            customerRepository.delete(getCustomer(tckn));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public String creditCalculation(Customer customer) {
        Scoring score = scoringService.getScoring(customer.getTckn());
        Application application = applicationService.getApplication(customer.getTckn());

        if ( score.getScoring() < 500) {
            application.setCreditLimit(0);
            application.setCreditResult(CreditResult.REJECTED.name());
            applicationRepository.save(application);
            sendSMS(customer);
            return application.getCreditResult();
        }

        if (score.getScoring() > 500 && score.getScoring() < 1000 && customer.getMonthlyIncome() < 5000) {
            application.setCreditLimit(10000);
            application.setCreditResult(CreditResult.APPROVED.name());
            applicationRepository.save(application);
            sendSMS(customer);
            return application.getCreditResult();
        }

        if (score.getScoring() > 500 && score.getScoring() < 1000 && customer.getMonthlyIncome() > 5000) {
            application.setCreditLimit(20000);
            application.setCreditResult(CreditResult.APPROVED.name());
            applicationRepository.save(application);
            sendSMS(customer);
            return application.getCreditResult();
        }

        if (score.getScoring() >= 1000) {
            application.setCreditLimit(creditLimitFactor * customer.getMonthlyIncome());
            application.setCreditResult(CreditResult.APPROVED.name());
            applicationRepository.save(application);
            sendSMS(customer);
            return application.getCreditResult();
        }
        return "Application Not Found!";
    }

    @Override
    public String sendSMS(Customer customer) {
        String message = "Dear " + customer.getFullname() + ", /n Your application is " + customer.getApplication().getCreditResult();

        if(customer.getApplication().getCreditResult() == CreditResult.REJECTED.name()){
            return message;
        }
        if (customer.getApplication().getCreditResult() == CreditResult.APPROVED.name()){
            return message;
        }
        return "Customer Not Found";
    }
}
