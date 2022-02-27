package com.creditsystem.creditsystem.controller;

import com.creditsystem.creditsystem.model.Application;
import com.creditsystem.creditsystem.model.Customer;
import com.creditsystem.creditsystem.model.Scoring;
import com.creditsystem.creditsystem.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping(value = "/all")
    public List<Customer> getAllCustomers(){
        List<Customer> allCustomers = customerService.getAllCustomers();
        return allCustomers;
    }

    @GetMapping(value = "/{tckn}")
    public Customer getCustomer(@PathVariable @RequestBody String tckn){
        return customerService.getCustomer(tckn);
    }

    @PostMapping(value = "/create/{tckn}")
    public void saveCustomer(@Valid @RequestBody Customer customer) {
        customerService.addCustomer(customer);
    }

    @PutMapping(value = "/update/{tckn}")
    public Customer updateCustomer(@PathVariable String tckn, @Valid @RequestBody Customer customer) {
        return customerService.updateCustomer(tckn,customer);
    }

    @DeleteMapping(value = "/delete/{tckn}")
    public boolean deleteCustomer(@PathVariable @RequestBody String tckn) {
       return customerService.deleteCustomer(tckn);
    }

}
