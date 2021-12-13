package com.example.coviddatademo.services;

import com.example.coviddatademo.dto.IndiaCovid19DTO;
import com.example.coviddatademo.models.IndiaCovid19Data;
import com.example.coviddatademo.repositories.IndiaCovid19DataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class IndiaCovid19Service {
    private final IndiaCovid19DataRepository indiaCovid19DataRepository;

    @Transactional(readOnly = true)
    public List<IndiaCovid19Data> getAllByState(String state) {
        return indiaCovid19DataRepository.findAllByState(state);
    }

    public void saveAllRecords(List<IndiaCovid19DTO> data) {
        List<IndiaCovid19Data> records = data.stream().map(this::toIndiaCovid19Data).collect(Collectors.toList());
        indiaCovid19DataRepository.saveAll(records);
    }

    private IndiaCovid19Data toIndiaCovid19Data(IndiaCovid19DTO dto) {
        IndiaCovid19Data record = new IndiaCovid19Data();
        record.setDate(dto.getDate());
        record.setTime(dto.getTime());
        record.setState(dto.getState());
        record.setConfirmedIndianNational(dto.getConfirmedIndianNational());
        record.setConfirmedForeignNational(dto.getConfirmedForeignNational());
        record.setCured(dto.getCured());
        record.setDeaths(dto.getDeaths());
        record.setConfirmed(dto.getConfirmed());
        return record;
    }
}
