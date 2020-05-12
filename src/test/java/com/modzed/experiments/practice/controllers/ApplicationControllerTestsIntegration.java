package com.modzed.experiments.practice.controllers;

import com.modzed.experiments.practice.PracticeApplication;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {PracticeApplication.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationControllerTestsIntegration {

    @LocalServerPort
    private int randomPort;

    @BeforeEach
    void setUp() {
        RestAssured.port = randomPort;
    }

    @Test
    public void shouldReturnAListOfApplications() {
        RestAssured
                .when()
                .get("/applications")
                .then()
                .statusCode(200);
    }
}
