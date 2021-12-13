package com.example.coviddatademo.converters;

import com.opencsv.bean.AbstractBeanField;
import org.springframework.stereotype.Component;

@Component
public class NumberConverter extends AbstractBeanField<Integer, String> {
    @Override protected Integer convert(String val) {
        if (val.contains("-")) return null;
        return Integer.parseInt(val);
    }
}
