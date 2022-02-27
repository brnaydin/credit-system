package com.creditsystem.creditsystem.service.Impl;

import com.creditsystem.creditsystem.model.Application;
import com.creditsystem.creditsystem.model.Scoring;
import com.creditsystem.creditsystem.repository.ApplicationRepository;
import com.creditsystem.creditsystem.repository.ScoringRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ScoringServiceImplTest {

    @Mock
    private ScoringRepository scoringRepository;

    @InjectMocks
    private ScoringServiceImpl scoringService;

    @Test
    void getScoring() {

        // init
        Scoring expectedScoring = new Scoring(1L,"11111111111", null );

        //stub when
        Mockito.when(scoringRepository.findScoringByTckn("11111111111")).thenReturn(Optional.of(expectedScoring));

        //then step
        Scoring actualScoring = scoringService.getScoring("11111111111");

        //valid step
        Assert.assertEquals(expectedScoring,actualScoring);
    }
}