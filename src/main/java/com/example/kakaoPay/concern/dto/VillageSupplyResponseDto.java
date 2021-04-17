package com.example.kakaoPay.concern.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class VillageSupplyResponseDto {
    private String name;
    @JsonProperty()
    private List<VillageSupplyDetailResponseDto> villageSupplyDetailResponseDtos;

    public VillageSupplyResponseDto(String name, List<VillageSupplyDetailResponseDto> villageSupplyDetailResponseDtos) {
        this.name = name;
        this.villageSupplyDetailResponseDtos = villageSupplyDetailResponseDtos;
    }
}
