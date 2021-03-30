package org.javaSchool.util;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collections;
import java.util.List;

public class Parser<T> {

    public List<T> parseVehicle(Class className, String filePath) {
        List<T> vehicles = Collections.EMPTY_LIST;
        try {
            vehicles = new CsvToBeanBuilder<T>(new FileReader(Constants.USER_DIR + filePath))
                    .withType(className).build().parse();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return vehicles;
    }
}
