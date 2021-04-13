package com.example.kakaoPay.service.exception;

public class DuplicateEmailExcption extends RuntimeException {
    public DuplicateEmailExcption() {
        super("Duplicated Email");
    }
}
