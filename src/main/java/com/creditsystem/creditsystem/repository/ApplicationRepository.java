package com.creditsystem.creditsystem.repository;

import com.creditsystem.creditsystem.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    Optional<Application> findApplicationByTckn(String tckn);

}
