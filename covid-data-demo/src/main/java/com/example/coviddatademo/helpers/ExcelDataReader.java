package com.example.coviddatademo.helpers;

import com.poiji.bind.Poiji;
import com.poiji.option.PoijiOptions;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

@Component
public class ExcelDataReader {

    public <T> List<T> readData(File file, Class<T> type, PoijiOptions poijiOptions) {
        return Poiji.fromExcel(file, type, poijiOptions);
    }
}
