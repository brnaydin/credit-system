package com.creditsystem.creditsystem.service.Impl;

import com.creditsystem.creditsystem.exception.NotFoundException;
import com.creditsystem.creditsystem.model.Customer;
import com.creditsystem.creditsystem.model.Scoring;
import com.creditsystem.creditsystem.repository.ScoringRepository;
import com.creditsystem.creditsystem.service.ScoringService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScoringServiceImpl implements ScoringService {

    private final ScoringRepository scoringRepository;

    @Override
    public Scoring getScoring(String tckn) {
        Optional<Scoring> scoring = scoringRepository.findScoringByTckn(tckn);
        return scoring.orElseThrow(()->new NotFoundException("Scoring"));
    }

    @Override
    public List<Scoring> getAllScorings() {
        return scoringRepository.findAll();
    }

}
