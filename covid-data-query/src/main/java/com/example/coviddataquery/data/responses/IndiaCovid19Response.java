package com.example.coviddataquery.data.responses;

import com.example.coviddataquery.data.domain.IndiaCovid19Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties
@AllArgsConstructor
public class IndiaCovid19Response {
    List<IndiaCovid19Data> data;
}
