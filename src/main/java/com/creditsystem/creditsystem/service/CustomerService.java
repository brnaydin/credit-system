package com.creditsystem.creditsystem.service;


import com.creditsystem.creditsystem.model.Customer;
import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomers();

    Customer getCustomer(String tckn);

    Customer addCustomer(Customer customer);

    Customer updateCustomer(String tckn, Customer customer);

    boolean deleteCustomer(String tckn);

    String creditCalculation(Customer customer);

    String sendSMS(Customer customer);

}
