package com.creditsystem.creditsystem.service.Impl;

import com.creditsystem.creditsystem.model.Application;
import com.creditsystem.creditsystem.model.Customer;
import com.creditsystem.creditsystem.repository.ApplicationRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class ApplicationServiceImplTest {

    @Mock
    private ApplicationRepository applicationRepository;

    @InjectMocks
    private ApplicationServiceImpl applicationService;

/*    @BeforeEach
    public void setup(){
        //init
        Application expectedApplication = new Application(1L,"11111111111", null, null, null);

        //stub - when
        Mockito.when(applicationRepository.findApplicationByTckn("11111111111")).thenReturn(Optional.of(expectedApplication));
    }*/

    @Test
    void getAllApplications() {
        Application application1 = new Application(1L,"11111111111", null, null, null);
        Application application2 = new Application(2L,"22222222222", null, null, null);
        Application application3 = new Application(3L,"33333333333", null, null, null);
        Application application4 = new Application(4L,"44444444444", null, null, null);
        Application application5 = new Application(5L,"55555555555", null, null, null);
        Application application6 = new Application(6L,"66666666666", null, null, null);
        Application application7 = new Application(7L,"77777777777", null, null, null);
        Application application8 = new Application(8L,"88888888888", null, null, null);
        Application application9 = new Application(9L,"99999999999", null, null, null);
        Application application10 = new Application(10L,"10000000000", null, null, null);
        Application application11 = new Application(11L,"11000000000", null, null, null);
        Application application12 = new Application(12L,"12000000000", null, null, null);
        Application application13 = new Application(13L,"13000000000", null, null, null);
        Application application14 = new Application(14L,"14000000000", null, null, null);
        Application application15 = new Application(15L,"15000000000", null, null, null);

        List<Application> applications = new ArrayList<>();
        applications.add(application1);
        applications.add(application2);
        applications.add(application3);
        applications.add(application4);
        applications.add(application5);
        applications.add(application6);
        applications.add(application7);
        applications.add(application8);
        applications.add(application9);
        applications.add(application10);
        applications.add(application11);
        applications.add(application12);
        applications.add(application13);
        applications.add(application14);
        applications.add(application15);

        // stub -when

        Mockito.when(applicationRepository.findAll()).thenReturn(applications);

        //then
        List<Application> allApplications = applicationService.getAllApplications();

        Assert.assertEquals(applications.size(), allApplications.size());

    }

    @Test
    void getApplication() {
        // init
        Application expectedApplication = new Application(1L,"11111111111", null, null, null);

        //stub when
        Mockito.when(applicationRepository.findApplicationByTckn("11111111111")).thenReturn(Optional.of(expectedApplication));

        //then step
        Application actualApplication = applicationService.getApplication("11111111111");

        //valid step
        Assert.assertEquals(expectedApplication,actualApplication);

    }

    @Test
    void addApplication() {
        // init
        Application expectedApplication = new Application(1L,"11111111111", null, null, null);

        //stub - when
        Mockito.when(applicationRepository.save(expectedApplication)).thenReturn(expectedApplication);

        //then
        applicationService.addApplication(expectedApplication);

        Mockito.verify(applicationRepository, Mockito.times(1)).save(expectedApplication);
    }

}