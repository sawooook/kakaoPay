package com.example.kakaoPay.controller;

import com.example.kakaoPay.concern.dto.VillageSupplyDetailResponseDto;
import com.example.kakaoPay.concern.dto.VillageSupplyResponseDto;
import com.example.kakaoPay.service.BillingPayService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("billing_pay")
public class BillingPayController {

    private final BillingPayService billingPayService;

    public BillingPayController(BillingPayService billingPayService) {
        this.billingPayService = billingPayService;
    }

    @GetMapping("/supply_status")
    public ResponseEntity financeSupplyStatus() {
        List<VillageSupplyDetailResponseDto> villageFinanceSupply = billingPayService.findVillageFinanceSupply();
        return ResponseEntity.ok().body(villageFinanceSupply);
    }
}
