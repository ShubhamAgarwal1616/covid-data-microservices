package com.example.coviddatademo.dto;

import com.example.coviddatademo.converters.NumberConverter;
import com.example.coviddatademo.converters.TimeConverter;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import com.opencsv.bean.CsvDate;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class IndiaCovid19DTO {
    @CsvBindByName(column = "Date")
    @CsvDate("yyyy-MM-dd")
    private LocalDate date;

    @CsvCustomBindByName(column = "Time", converter = TimeConverter.class)
    private LocalTime time;

    @CsvBindByName(column = "State/UnionTerritory")
    private String state;

    @CsvCustomBindByName(column = "ConfirmedIndianNational", converter = NumberConverter.class)
    private Integer confirmedIndianNational;

    @CsvCustomBindByName(column = "ConfirmedForeignNational", converter = NumberConverter.class)
    private Integer confirmedForeignNational;

    @CsvBindByName(column = "Cured")
    private Integer cured;

    @CsvBindByName(column = "Deaths")
    private Integer deaths;

    @CsvBindByName(column = "Confirmed")
    private Integer confirmed;
}
