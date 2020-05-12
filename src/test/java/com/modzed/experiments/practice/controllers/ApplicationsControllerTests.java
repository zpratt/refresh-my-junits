package com.modzed.experiments.practice.controllers;

import com.github.javafaker.Faker;
import com.modzed.experiments.practice.services.ApplicationServices;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class ApplicationsControllerTests {

    ApplicationServices applicationServices = mock(ApplicationServices.class);
    Faker faker = new Faker();

    private ApplicationsController givenAnApplicationController() {
        return new ApplicationsController(applicationServices);
    }

    @Test
    public void shouldReturnAListOfApplications() {
        ApplicationsController applicationsController = givenAnApplicationController();
        List<String> expectedApplicationList = Arrays.asList("Foo", "Bar");

        when(applicationServices.getAllApplications()).thenReturn(expectedApplicationList);

        List<String> applications = applicationsController.getAllApplications();

        verify(applicationServices, Mockito.times(1)).getAllApplications();

        assertSame(expectedApplicationList, applications);
    }

    @Test
    void shouldReturnASingleApplication() {
        ApplicationsController applicationsController = givenAnApplicationController();
        UUID id = UUID.fromString(faker.internet().uuid());
        String expectedApplicationName = faker.app().name();

        when(applicationServices.getApplicationById(id)).thenReturn(expectedApplicationName);

        String appName = applicationsController.getApplicationById(id);

        assertSame(expectedApplicationName, appName);
    }
}
