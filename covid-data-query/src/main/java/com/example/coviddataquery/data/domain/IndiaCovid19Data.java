package com.example.coviddataquery.data.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties
@NoArgsConstructor
@AllArgsConstructor
public class IndiaCovid19Data {
    private UUID id;
    private LocalDate date;
    private LocalTime time;
    private String state;
    private Integer confirmedIndianNational;
    private Integer confirmedForeignNational;
    private Integer cured;
    private Integer deaths;
    private Integer confirmed;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

