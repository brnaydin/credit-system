package com.creditsystem.creditsystem.repository;

import com.creditsystem.creditsystem.model.Scoring;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ScoringRepository extends JpaRepository<Scoring, Long> {

    Optional<Scoring> findScoringByTckn(String tckn);
}
