package com.example.coviddatademo.services;

import com.example.coviddatademo.dto.StateWiseTestingDetailsDTO;
import com.example.coviddatademo.models.StateWiseTestingDetails;
import com.example.coviddatademo.repositories.StateWiseTestingDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class StateWiseTestingDetailService {
    private final StateWiseTestingDetailsRepository stateWiseTestingDetailsRepository;

    public void saveAllRecords(List<StateWiseTestingDetailsDTO> data) {
        List<StateWiseTestingDetails> records = data.stream().map(this::toStateWiseTestingDetails).collect(Collectors.toList());
        stateWiseTestingDetailsRepository.saveAll(records);
    }

    private StateWiseTestingDetails toStateWiseTestingDetails(StateWiseTestingDetailsDTO dto) {
        StateWiseTestingDetails record = new StateWiseTestingDetails();
        record.setDate(dto.getDate());
        record.setState(dto.getState());
        record.setTotalSamples(dto.getTotalSamples());
        record.setNegativeSamples(dto.getNegativeSamples());
        record.setPositiveSamples(dto.getPositiveSamples());
        return record;
    }
}
