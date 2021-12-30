package com.example.coviddataquery.data.controllers;

import com.example.coviddataquery.data.domain.IndiaCovid19Data;
import com.example.coviddataquery.data.responses.IndiaCovid19Response;
import com.example.coviddataquery.security.annotations.AnyAuthenticatedUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@AnyAuthenticatedUser
public class DataController {
    private final RestTemplate restTemplate;

    @GetMapping("/india-covid-19/state")
    public ResponseEntity<IndiaCovid19Response> getIndiaDataByState(@RequestParam(name = "name", required = true) String state) throws URISyntaxException {
        URI uri = new URI("http://localhost:8080/api/india-covid-19/state?name=Kerala");
        IndiaCovid19Data[] data = restTemplate.getForObject(uri, IndiaCovid19Data[].class);
        return ResponseEntity.ok(new IndiaCovid19Response(Arrays.asList(data)));
    }
}
