package com.example.kakaoPay.concern.utils;

import com.opencsv.CSVReader;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OpenCSV {

    public static List<List<Integer>> readCSV(MultipartFile file) {
        List<List<Integer>> dataList = null;

        try {
            InputStream inputStream = file.getInputStream();
            CSVReader csvReader = new CSVReader(new InputStreamReader(inputStream));
            String[] row;
            dataList = new ArrayList<>();

            int count = 0;
            // 1. 첫번째 컬럼은 제외 후 그다음 컬럼부터 리스트에 저장을함
            // 2. 컬럼의 갯수가 총 10개
            // 3. 데이터중 "," 들어가는건 전부 제거
            while ((row = csvReader.readNext()) != null) {
                if (count != 0) {
                    List<Integer> rowList = new ArrayList<>();
                    for (int i = 0; i < 10; i++) {
                        rowList.add(Integer.valueOf(row[i].replaceAll(",","")));
                    }
                    dataList.add(rowList);
                }
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataList;
    }
}
