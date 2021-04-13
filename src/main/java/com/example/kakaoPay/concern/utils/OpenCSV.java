package com.example.kakaoPay.concern.utils;

import com.opencsv.CSVReader;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

public class OpenCSV {

    public static void readCSV(MultipartFile file) {
        try {
            InputStream inputStream = file.getInputStream();
            CSVReader csvReader = new CSVReader(new InputStreamReader(inputStream));
            String[] row;
            csvReader.readNext();
            while ((row = csvReader.readNext()) != null) {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void saveCSV(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        File destination = new File("../", fileName);
        destination.getParentFile().mkdir();
        try {
            file.transferTo(destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
