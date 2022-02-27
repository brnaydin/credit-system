package com.creditsystem.creditsystem.service;

import com.creditsystem.creditsystem.model.Scoring;

import java.util.List;


public interface ScoringService {

    Scoring getScoring(String tckn);

    List<Scoring> getAllScorings();

}
