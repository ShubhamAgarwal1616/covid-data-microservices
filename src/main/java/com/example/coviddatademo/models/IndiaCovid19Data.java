package com.example.coviddatademo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "Covid_19_India_details")
@Getter
@Setter
public class IndiaCovid19Data {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "time")
    private LocalTime time;

    @Column(name = "state_or_union_territory")
    private String state;

    @Column(name = "confirmed_indian_national")
    private Integer confirmedIndianNational;

    @Column(name = "confirmed_foreign_national")
    private Integer confirmedForeignNational;

    @Column(name = "cured")
    private Integer cured;

    @Column(name = "deaths")
    private Integer deaths;

    @Column(name = "confirmed")
    private Integer confirmed;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Column(insertable = false)
    private LocalDateTime updatedAt;
}
