package com.example.coviddatademo.controllers;

import com.example.coviddatademo.dto.CovidVaccineStateWiseDTO;
import com.example.coviddatademo.dto.IndiaCovid19DTO;
import com.example.coviddatademo.dto.StateWiseTestingDetailsDTO;
import com.example.coviddatademo.services.CovidVaccineStateWiseService;
import com.example.coviddatademo.services.IndiaCovid19Service;
import com.example.coviddatademo.services.StateWiseTestingDetailService;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@RestController
@RequestMapping("/api/covid-data")
@RequiredArgsConstructor
public class CovidDataController {
    private static final String covid19IndiaPath = "src/main/resources/CovidExcelFiles/covid_19_india.csv";
    private static final String covidVaccineStateWise = "src/main/resources/CovidExcelFiles/covid_vaccine_statewise.csv";
    private static final String stateWiseTestingDetails = "src/main/resources/CovidExcelFiles/StatewiseTestingDetails.csv";

    private final IndiaCovid19Service indiaCovid19Service;
    private final StateWiseTestingDetailService stateWiseTestingDetailService;
    private final CovidVaccineStateWiseService covidVaccineStateWiseService;

    @PostMapping("/import-data")
    public ResponseEntity<String> ImportCovidData() throws FileNotFoundException {
        FileReader excelFileReader = new FileReader(covid19IndiaPath);
        List<IndiaCovid19DTO> indiaCovid19DTOs = new CsvToBeanBuilder(excelFileReader).withType(IndiaCovid19DTO.class).build().parse();
        indiaCovid19Service.saveAllRecords(indiaCovid19DTOs);

        excelFileReader = new FileReader(covidVaccineStateWise);
        List<CovidVaccineStateWiseDTO> covidVaccineStateWiseDTOS = new CsvToBeanBuilder(excelFileReader).withType(CovidVaccineStateWiseDTO.class).build().parse();
        covidVaccineStateWiseService.saveAllRecords(covidVaccineStateWiseDTOS);

        excelFileReader = new FileReader(stateWiseTestingDetails);
        List<StateWiseTestingDetailsDTO> stateWiseTestingDetailsDTOs = new CsvToBeanBuilder(excelFileReader).withType(StateWiseTestingDetailsDTO.class).build().parse();
        stateWiseTestingDetailService.saveAllRecords(stateWiseTestingDetailsDTOs);

        return ResponseEntity.status(HttpStatus.CREATED).body("Covid details imported successfully");
    }
}
