package com.example.coviddatademo.controllers;

import com.example.coviddatademo.models.IndiaCovid19Data;
import com.example.coviddatademo.responses.IndiaCovid19Response;
import com.example.coviddatademo.services.IndiaCovid19Service;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/india-covid-19")
@RequiredArgsConstructor
public class IndiaCovid19Controller {
    private final IndiaCovid19Service indiaDataService;
    private final ModelMapper modelMapper;

    @GetMapping("/state")
    public ResponseEntity<List<IndiaCovid19Response>> getIndiaDataByState(@RequestParam(name = "name", required = false) String state) {
        List<IndiaCovid19Data> data = indiaDataService.getAllByState(state);
        List<IndiaCovid19Response> list = new ArrayList<>();
        for (IndiaCovid19Data d : data) {
            list.add(modelMapper.map(d, IndiaCovid19Response.class));
        }
        return ResponseEntity.ok(list);
    }

}
