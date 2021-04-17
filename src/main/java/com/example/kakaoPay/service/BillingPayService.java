package com.example.kakaoPay.service;

import com.example.kakaoPay.concern.dto.VillageSupplyDetailResponseDto;
import com.example.kakaoPay.domain.BillingPay;
import com.example.kakaoPay.domain.Institute;
import com.example.kakaoPay.domain.repository.BillingPayRepository;
import com.example.kakaoPay.domain.repository.InstituteRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        for (List<Integer> rowList : dataList) {
            for (int i = 2; i < rowList.size(); i++) {
                Institute institute = instituteRepository.findByState(Institute.getBankState(i));
                System.out.println(institute.getState());
                BillingPay billingPay = new BillingPay(rowList.get(0), rowList.get(1), rowList.get(i), institute);
                billingPayRepository.save(billingPay);
            }
        }
    }

    @Transactional(readOnly = true)
    public List<VillageSupplyDetailResponseDto> findVillageFinanceSupply() {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        List<BillingPay> dataList = billingPayRepository.findAll(sort);

        int tempYear = dataList.get(0).getYear();
        List<VillageSupplyDetailResponseDto> detailAmountList = new ArrayList<>();
        int totalAmount = 0;
        Map<String, Integer> detailAmountMap = new HashMap<>();

        for (BillingPay billingPay : dataList) {
            if (tempYear != billingPay.getYear()) {

                VillageSupplyDetailResponseDto supplyDetail = new VillageSupplyDetailResponseDto(tempYear + "년", totalAmount, detailAmountMap);
                detailAmountList.add(supplyDetail);
                tempYear = billingPay.getYear();
                totalAmount = 0;
                detailAmountMap = new HashMap<>();
            }
            totalAmount += billingPay.getMoney();
            detailAmountMap.put(String.valueOf(billingPay.getInstitute().getState().getName()), billingPay.getMoney());
        }

        return detailAmountList;
    }
}
