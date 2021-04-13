package com.example.kakaoPay.controller;

import antlr.Utils;
import com.example.kakaoPay.concern.utils.OpenCSV;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("data")
public class DataUpLoadController {

    // 파일 업로드 화면
    @GetMapping("/new")
    public String upLoad() {
        return "/data/new.html";
    }

    // 파일 업로드 완료시
    @PostMapping
    public String saveCSV(@RequestParam("file") MultipartFile file) {
//        OpenCSV.saveCSV(file);
        OpenCSV.readCSV(file);

        return "/data/create.html";
    }
}
