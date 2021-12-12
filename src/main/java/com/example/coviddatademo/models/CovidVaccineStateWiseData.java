package com.example.coviddatademo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Covid_vaccine_state_wise_details")
@Getter
@Setter
public class CovidVaccineStateWiseData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "record_updated_on")
    private LocalDate recordUpdatedOn;

    @Column(name = "state_or_union_territory")
    private String state;

    @Column(name = "total_doses_administered")
    private Double totalDosesAdministered;

    @Column(name = "total_session_conducted")
    private Double totalSessionsConducted;

    @Column(name = "total_sites")
    private Double totalSites;

    @Column(name = "first_does_administered")
    private Double firstDoseAdministered;

    @Column(name = "second_dose_administered")
    private Double secondDoesAdministered;

    @Column(name = "male_individuals_vaccinated")
    private Double maleIndividualsVaccinated;

    @Column(name = "female_individuals_vaccinated")
    private Double femaleIndividualsVaccinated;

    @Column(name = "transgender_individuals_vaccinated")
    private Double transgenderIndividualsVaccinated;

    @Column(name = "total_covaxin_administered")
    private Double totalCovaxinAdministered;

    @Column(name = "total_covishield_administered")
    private Double totalCoviShieldAdministered;

    @Column(name = "total_sputnik_v_administered")
    private Double totalSputnikVAdministered;

    @Column(name = "aefi")
    private Double aefi;

    @Column(name = "age_18_45")
    private Double age_18_45;

    @Column(name = "age_45_60")
    private Double age_45_60;

    @Column(name = "age_60_above")
    private Double age_60_above;

    @Column(name = "total_individuals_vaccinated")
    private Double totalIndividualsVaccinated;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Column(insertable = false)
    private LocalDateTime updatedAt;
}
