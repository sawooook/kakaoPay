package com.example.kakaoPay.concern.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SignUpRequestDto {
    private String email;
    private String password;

    public SignUpRequestDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
