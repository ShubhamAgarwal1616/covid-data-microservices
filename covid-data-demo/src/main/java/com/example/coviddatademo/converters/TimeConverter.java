package com.example.coviddatademo.converters;

import com.opencsv.bean.AbstractBeanField;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Component
public class TimeConverter extends AbstractBeanField<Integer, String> {
    @Override protected LocalTime convert(String val) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("h:m a", Locale.ENGLISH);
        return LocalTime.parse(val, inputFormatter);
    }
}
