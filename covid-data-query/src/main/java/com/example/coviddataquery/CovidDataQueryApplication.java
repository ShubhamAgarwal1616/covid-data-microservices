package com.example.coviddataquery;

import com.example.coviddataquery.security.config.JwtProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({JwtProperties.class})
public class CovidDataQueryApplication {

	public static void main(String[] args) {
		SpringApplication.run(CovidDataQueryApplication.class, args);
	}

}
