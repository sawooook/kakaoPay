package com.example.kakaoPay.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("data")
public class DataUpLoadController {

    @GetMapping("/new")
    public String upLoad() {
        System.out.println("============");
        return "/data/new.html";
    }
}
