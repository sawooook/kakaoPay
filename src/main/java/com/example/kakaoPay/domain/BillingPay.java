package com.example.kakaoPay.domain;

import javax.persistence.*;
import java.time.Month;
import java.time.Year;

@Entity
public class BillingPay {
    @Id
    private Long id;
    private int year;
    private int month;
    private int Money;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "")
    private Institute institute;
}
