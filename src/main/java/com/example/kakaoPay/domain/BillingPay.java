package com.example.kakaoPay.domain;

import javax.persistence.*;
import java.time.Month;
import java.time.Year;

@Entity
public class BillingPay {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int year;
    private int month;
    private int Money;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Institute_id")
    private Institute institute;

    public BillingPay(int year, int month, int money, Institute institute) {
        this.year = year;
        this.month = month;
        Money = money;
        this.institute = institute;
    }
}
