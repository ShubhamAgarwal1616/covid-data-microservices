package com.example.coviddatademo.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IndiaCovid19Response {
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

