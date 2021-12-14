package com.example.coviddatademo.dto;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import lombok.Data;

import java.time.LocalDate;

@Data
public class StateWiseTestingDetailsDTO {
    @CsvBindByName(column = "Date")
    @CsvDate("yyyy-MM-dd")
    private LocalDate date;

    @CsvBindByName(column = "State")
    private String state;

    @CsvBindByName(column = "TotalSamples")
    private Double totalSamples;

    @CsvBindByName(column = "Negative")
    private Double negativeSamples;

    @CsvBindByName(column = "Positive")
    private Double positiveSamples;
}
