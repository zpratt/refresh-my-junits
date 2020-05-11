package com.modzed.experiments.practice.controllers;

import com.modzed.experiments.practice.services.ApplicationServices;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class ApplicationTests {

    ApplicationServices applicationServices = mock(ApplicationServices.class);

    private Applications givenAnApplicationController() {
        return new Applications(applicationServices);
    }

    @Test
    public void shouldReturnAListOfApplications() {
        Applications applicationsController = givenAnApplicationController();
        List<String> expectedApplicationList = Arrays.asList("Foo", "Bar");

        when(applicationServices.getAllApplications()).thenReturn(expectedApplicationList);

        List<String> applications = applicationsController.getAllApplications();

        verify(applicationServices, Mockito.times(1)).getAllApplications();

        assertEquals(expectedApplicationList, applications);
        assertSame(expectedApplicationList, applications);
    }

    @Test
    void shouldReturnASingleApplication() {
        Applications applications = givenAnApplicationController();

        applications.getApplicationById();
    }
}
