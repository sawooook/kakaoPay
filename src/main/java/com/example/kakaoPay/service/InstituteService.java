package com.example.kakaoPay.service;

import com.example.kakaoPay.domain.Institute;
import com.example.kakaoPay.domain.repository.InstituteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstituteService {

    private final InstituteRepository instituteRepository;

    public InstituteService(InstituteRepository instituteRepository) {
        this.instituteRepository = instituteRepository;
    }

    public List<String> bankList() {
        List<Institute> resultList = instituteRepository.findAll();
        List<String> response = new ArrayList<>();
        for (Institute institute : resultList) {
            response.add(institute.getState().getName());
        }
        return response;
    }
}
