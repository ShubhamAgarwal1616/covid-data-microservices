package com.example.coviddataquery.data.controllers;

import com.example.coviddataquery.data.domain.IndiaCovid19Data;
import com.example.coviddataquery.data.responses.IndiaCovid19Response;
import com.example.coviddataquery.security.annotations.AnyAuthenticatedUser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@AnyAuthenticatedUser
public class DataController {
    private final RestTemplate restTemplate;

    @Value("${covid.rest.api.data-service-host}")
    private String dataServiceHost;

    @GetMapping("/india-covid-19/state")
    public ResponseEntity<IndiaCovid19Response> getIndiaDataByState(@RequestParam(name = "name", required = true) String state) throws URISyntaxException {
        URI uri = new URI(dataServiceHost + "/api/india-covid-19/state?name=Kerala");
        IndiaCovid19Data[] data = restTemplate.getForObject(uri, IndiaCovid19Data[].class);
        return ResponseEntity.ok(new IndiaCovid19Response(Arrays.asList(data)));
    }

    @PostMapping("/data/import")
    public ResponseEntity<String> ImportCovidData() throws URISyntaxException, FileNotFoundException {
        try {
            URI uri = new URI(dataServiceHost + "/api/covid-data/import-data");
            ResponseEntity<String> res = restTemplate.postForEntity(uri, HttpMethod.POST, String.class);
            return ResponseEntity.ok(res.getBody());
        } catch (Exception e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }
}
