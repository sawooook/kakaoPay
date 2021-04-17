package com.example.kakaoPay.controller;

import com.example.kakaoPay.service.InstituteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("institute")
public class InstituteController {

    private final InstituteService instituteService;

    public InstituteController(InstituteService instituteService) {
        this.instituteService = instituteService;
    }

    @GetMapping("/bank_list")
    public ResponseEntity bankList() {
        List<String> response = instituteService.bankList();
        return ResponseEntity.ok().body(response);
    }

}
