package com.modzed.experiments.practice.controllers;

import com.modzed.experiments.practice.services.ApplicationServices;

import java.util.List;

public class Applications {
    private final ApplicationServices applicationService;

    public Applications(ApplicationServices applicationServices) {
        this.applicationService = applicationServices;
    }

    public List<String> getAllApplications() {
        List<String> allApplications = applicationService.getAllApplications();
        return allApplications;
    }

    public void getApplicationById() {

    }
}
