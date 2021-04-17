package com.example.kakaoPay.controller;

import com.example.kakaoPay.concern.utils.OpenCSV;
import com.example.kakaoPay.service.BillingPayService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("data")
public class DataUpLoadController {

    private final BillingPayService billingPayService;

    public DataUpLoadController(BillingPayService billingPayService) {
        this.billingPayService = billingPayService;
    }

    // 파일 업로드 화면
    @GetMapping("/new")
    public String upLoad() {
        return "/data/new.html";
    }

    // 파일 업로드 완료시
    @PostMapping
    public String saveCSV(@RequestParam("file") MultipartFile file) {
//        OpenCSV.saveCSV(file);
        List<List<Integer>> dataList = OpenCSV.readCSV(file);
        billingPayService.addCSVData(dataList);
        return "/data/new.html";
    }
}
