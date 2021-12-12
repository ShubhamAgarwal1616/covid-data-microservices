package com.example.coviddatademo.repositories;

import com.example.coviddatademo.models.IndiaCovid19Data;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IndiaCovid19DataRepository extends CrudRepository<IndiaCovid19Data, Integer> {
    List<IndiaCovid19Data> findAllByState(String state);
}
