package com.creditsystem.creditsystem.repository;

import com.creditsystem.creditsystem.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByTckn(String tckn);



}
