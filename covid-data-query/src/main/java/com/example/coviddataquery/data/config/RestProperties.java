package com.example.coviddataquery.data.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

@ConfigurationProperties("covid.rest.api")
@Validated
@Setter
@Getter
public class RestProperties {
    @NotEmpty(message = "data service host can not be empty")
    private String dataServiceHost;
}
