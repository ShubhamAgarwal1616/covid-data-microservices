package com.example.coviddatademo.dto;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CovidVaccineStateWiseDTO {
    @CsvBindByName(column = "Updated On")
    @CsvDate("dd/MM/yyyy")
    private LocalDate recordUpdatedOn;

    @CsvBindByName(column = "State")
    private String state;

    @CsvBindByName(column = "Total Doses Administered")
    private Double totalDosesAdministered;

    @CsvBindByName(column = "Total Sessions Conducted")
    private Double totalSessionsConducted;

    @CsvBindByName(column = "Total Sites")
    private Double totalSites;

    @CsvBindByName(column = "First Dose Administered")
    private Double firstDoseAdministered;

    @CsvBindByName(column = "Second Dose Administered")
    private Double secondDoesAdministered;

    @CsvBindByName(column = "Male(Individuals Vaccinated)")
    private Double maleIndividualsVaccinated;

    @CsvBindByName(column = "Female(Individuals Vaccinated)")
    private Double femaleIndividualsVaccinated;

    @CsvBindByName(column = "Transgender(Individuals Vaccinated)")
    private Double transgenderIndividualsVaccinated;

    @CsvBindByName(column = "Total Covaxin Administered")
    private Double totalCovaxinAdministered;

    @CsvBindByName(column = "Total CoviShield Administered")
    private Double totalCoviShieldAdministered;

    @CsvBindByName(column = "Total Sputnik V Administered")
    private Double totalSputnikVAdministered;

    @CsvBindByName(column = "AEFI")
    private Double aefi;

    @CsvBindByName(column = "18-45 years (Age)")
    private Double age_18_45;

    @CsvBindByName(column = "45-60 years (Age)")
    private Double age_45_60;

    @CsvBindByName(column = "60+ years (Age)")
    private Double age_60_above;

    @CsvBindByName(column = "Total Individuals Vaccinated")
    private Double totalIndividualsVaccinated;
}
