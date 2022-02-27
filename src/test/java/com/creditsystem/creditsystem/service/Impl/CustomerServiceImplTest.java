package com.creditsystem.creditsystem.service.Impl;

import com.creditsystem.creditsystem.model.Application;
import com.creditsystem.creditsystem.model.Customer;
import com.creditsystem.creditsystem.model.Scoring;
import com.creditsystem.creditsystem.repository.ApplicationRepository;
import com.creditsystem.creditsystem.repository.CustomerRepository;
import com.creditsystem.creditsystem.repository.ScoringRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.WeakHashMap;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;


    @Test
    void getCustomer() {

        // init
        Application application = new Application(1L,"11111111111", null, null, null);
        Customer expectedCustomer = new Customer(1L, "11111111111", "ALTAN AKPINARLI", 1100, "5353215476" , application );

        //stub when
        Mockito.when(customerRepository.findByTckn("11111111111")).thenReturn(Optional.of(expectedCustomer));

        //then step
        Customer actualCustomer = customerService.getCustomer("11111111111");

        //valid step
        Assert.assertEquals(expectedCustomer,actualCustomer);
    }


}