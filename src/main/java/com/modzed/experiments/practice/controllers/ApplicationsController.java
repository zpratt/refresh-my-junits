package com.modzed.experiments.practice.controllers;

import com.modzed.experiments.practice.services.ApplicationServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class ApplicationsController {
    private final ApplicationServices applicationService;

    public ApplicationsController(ApplicationServices applicationServices) {
        this.applicationService = applicationServices;
    }

    @GetMapping(path = "/applications")
    public List<String> getAllApplications() {
        return applicationService.getAllApplications();
    }

    public String getApplicationById(UUID id) {
        return applicationService.getApplicationById(id);
    }
}
