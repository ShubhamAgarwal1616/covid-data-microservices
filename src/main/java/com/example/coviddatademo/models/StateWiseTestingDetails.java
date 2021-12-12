package com.example.coviddatademo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "State_wise_testing_details")
@Getter
@Setter
public class StateWiseTestingDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "state_or_union_territory")
    private String state;

    @Column(name = "total_samples")
    private Double totalSamples;

    @Column(name = "negative_samples")
    private Double negativeSamples;

    @Column(name = "positive_samples")
    private Double positiveSamples;
}
