package com.example.coviddatademo.services;

import com.example.coviddatademo.dto.CovidVaccineStateWiseDTO;
import com.example.coviddatademo.models.CovidVaccineStateWiseData;
import com.example.coviddatademo.repositories.CovidVaccineStateWiseDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CovidVaccineStateWiseService {
    private final CovidVaccineStateWiseDataRepository covidVaccineStateWiseDataRepository;

    public void saveAllRecords(List<CovidVaccineStateWiseDTO> data) {
        List<CovidVaccineStateWiseData> records = data.stream().map(this::toCovidVaccineStateWise).collect(Collectors.toList());
        covidVaccineStateWiseDataRepository.saveAll(records);
    }

    private CovidVaccineStateWiseData toCovidVaccineStateWise(CovidVaccineStateWiseDTO dto) {
        CovidVaccineStateWiseData record = new CovidVaccineStateWiseData();
        record.setRecordUpdatedOn(dto.getRecordUpdatedOn());
        record.setState(dto.getState());
        record.setTotalDosesAdministered(dto.getTotalDosesAdministered());
        record.setTotalSessionsConducted(dto.getTotalSessionsConducted());
        record.setTotalSites(dto.getTotalSites());
        record.setFirstDoseAdministered(dto.getFirstDoseAdministered());
        record.setSecondDoesAdministered(dto.getSecondDoesAdministered());
        record.setMaleIndividualsVaccinated(dto.getMaleIndividualsVaccinated());
        record.setFemaleIndividualsVaccinated(dto.getFemaleIndividualsVaccinated());
        record.setTransgenderIndividualsVaccinated(dto.getTransgenderIndividualsVaccinated());
        record.setTotalCovaxinAdministered(dto.getTotalCovaxinAdministered());
        record.setTotalCoviShieldAdministered(dto.getTotalCoviShieldAdministered());
        record.setTotalSputnikVAdministered(dto.getTotalSputnikVAdministered());
        record.setAefi(dto.getAefi());
        record.setAge_18_45(dto.getAge_18_45());
        record.setAge_45_60(dto.getAge_45_60());
        record.setAge_60_above(dto.getAge_60_above());
        record.setTotalIndividualsVaccinated(dto.getTotalIndividualsVaccinated());
        return record;
    }
}
