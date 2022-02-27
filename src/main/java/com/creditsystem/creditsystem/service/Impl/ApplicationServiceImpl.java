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


import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;

    @Autowired
    CustomerService customerService;

    @Override
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    @Override
    public Application getApplication(String tckn) {
        Optional<Application> application = applicationRepository.findApplicationByTckn(tckn);
        return application.orElseThrow(()->new NotFoundException("Application"));
    }

    @Override
    public Application addApplication(Application application) {
        application.setCreatedAt(new Date(System.currentTimeMillis()));
        return applicationRepository.save(application);
    }

    @Override
    public Application updateApplication(String tckn, Application app) {
        Application application = applicationRepository.findApplicationByTckn(tckn).orElseThrow(()-> new NotFoundException("Application"));
        application.setId(app.getId());
        application.setCreditLimit(app.getCreditLimit());
        application.setCreditResult(app.getCreditResult());
        application.setTckn(app.getTckn());
        return applicationRepository.save(application);
    }



}
