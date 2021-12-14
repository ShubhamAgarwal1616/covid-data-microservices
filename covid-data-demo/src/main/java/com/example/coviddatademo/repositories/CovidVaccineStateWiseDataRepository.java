package com.example.coviddatademo.repositories;

import com.example.coviddatademo.models.CovidVaccineStateWiseData;
import org.springframework.data.repository.CrudRepository;

public interface CovidVaccineStateWiseDataRepository extends CrudRepository<CovidVaccineStateWiseData, Integer> {
}
