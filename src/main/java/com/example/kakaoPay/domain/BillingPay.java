package com.example.kakaoPay.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.Month;
import java.time.Year;

@Entity
@Getter
public class BillingPay {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int year;

    private int month;

    private int money;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "institute_id")
    private Institute institute;

    public BillingPay(int year, int month, int money, Institute institute) {
        this.year = year;
        this.month = month;
        this.money = money;
        this.institute = institute;
    }

    public BillingPay() {
    }
}
