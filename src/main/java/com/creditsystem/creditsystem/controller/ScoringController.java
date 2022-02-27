package com.creditsystem.creditsystem.controller;

import com.creditsystem.creditsystem.model.Application;
import com.creditsystem.creditsystem.model.Scoring;
import com.creditsystem.creditsystem.service.ScoringService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/scoring")
public class ScoringController {

    private final ScoringService scoringService;

    @GetMapping(value= "/{tckn}")
    public Scoring getScoring(@PathVariable @RequestBody String tckn){
        return scoringService.getScoring(tckn);
    }

    @GetMapping(value = "/all")
    public List<Scoring> getAllApplications(){
        List<Scoring> allScorings = scoringService.getAllScorings();
        return allScorings;
    }

}
