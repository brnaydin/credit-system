package com.creditsystem.creditsystem.controller;

import com.creditsystem.creditsystem.model.Application;
import com.creditsystem.creditsystem.repository.ApplicationRepository;
import com.creditsystem.creditsystem.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/application")
public class ApplicationController {

    private final ApplicationService applicationService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<Application>> getAllApplications(){
        return new ResponseEntity<List<Application>>( applicationService.getAllApplications(), HttpStatus.OK);
    }

    @GetMapping(value = "/{tckn}")
    public Application getApplication(@PathVariable @RequestBody String tckn){
        return applicationService.getApplication(tckn);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Application> saveApplication(@Valid @RequestBody Application application) {
        return new ResponseEntity<Application>(applicationService.addApplication(application), HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{tckn}")
    public Application updateApplication(@PathVariable String tckn, @Valid @RequestBody Application application) {
        return applicationService.updateApplication(tckn, application);
    }

}
