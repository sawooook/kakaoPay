package com.example.kakaoPay.service;

import com.example.kakaoPay.domain.BillingPay;
import com.example.kakaoPay.domain.Institute;
import com.example.kakaoPay.domain.InstituteState;
import com.example.kakaoPay.domain.repository.BillingPayRepository;
import com.example.kakaoPay.domain.repository.InstituteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BillingPayService {
    private final BillingPayRepository billingPayRepository;
    private final InstituteRepository instituteRepository;

    public BillingPayService(BillingPayRepository billingPayRepository, InstituteRepository instituteRepository) {
        this.billingPayRepository = billingPayRepository;
        this.instituteRepository = instituteRepository;
    }

    @Transactional
    public void addCSVData(List<List<Integer>> dataList) {
        dbinit();

        for (List<Integer> rowList : dataList) {
            for (int i = 2; i < rowList.size(); i++) {
                InstituteState state = Institute.getBankState(i);
                Institute institute = new Institute(state);
                BillingPay billingPay = new BillingPay(rowList.get(0), rowList.get(1), rowList.get(i), institute);
                billingPayRepository.save(billingPay);
            }
        }
    }

    @Transactional
    public void dbinit() {
        for (int i = 2; i < 12; i++) {
            System.out.println(i+"  ");
            InstituteState state = Institute.getBankState(i);
            Institute institute = new Institute(state);
            instituteRepository.save(institute);
        }
    }
}
