package com.creditsystem.creditsystem.service;

import com.creditsystem.creditsystem.model.Application;
import com.creditsystem.creditsystem.model.Customer;

import java.util.List;

public interface ApplicationService {

    List<Application> getAllApplications();

    Application getApplication(String tckn);

    Application addApplication(Application application);

    Application updateApplication(String tckn, Application application);


}
