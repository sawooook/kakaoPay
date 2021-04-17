package com.example.kakaoPay.concern.dto;

import com.example.kakaoPay.domain.Institute;
import com.example.kakaoPay.domain.InstituteState;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter @Setter
public class VillageSupplyDetailResponseDto {
    private String year;

    @JsonProperty("total_amount")
    private int totalAmount;

    @JsonProperty("detail_amount")
    private Map<String, Integer> detailAmount;

    public VillageSupplyDetailResponseDto(String year, int totalAmount, Map<String, Integer> detailAmount) {
        this.year = year;
        this.totalAmount = totalAmount;
        this.detailAmount = detailAmount;
    }
}
