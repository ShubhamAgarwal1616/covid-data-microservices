package com.example.coviddatademo.services;

import com.example.coviddatademo.models.IndiaCovid19Data;
import com.example.coviddatademo.repositories.IndiaCovid19DataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class IndiaCovid19Service {
    private final IndiaCovid19DataRepository indiaCovid19DataRepository;

    @Transactional(readOnly = true)
    public List<IndiaCovid19Data> getAllByState(String state) {
        return indiaCovid19DataRepository.findAllByState(state);
    }
}
