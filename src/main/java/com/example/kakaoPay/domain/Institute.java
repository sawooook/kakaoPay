package com.example.kakaoPay.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Institute {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private InstituteState state;

    @OneToMany(mappedBy = "institute")
    List<BillingPay> billingPayList = new ArrayList<>();

    public Institute(InstituteState state) {
        this.state = state;
    }

    public Institute() {
    }

    public static InstituteState getBankState(int listNum) {
        switch(listNum) {
            case 2:
                return InstituteState.City;
            case 3:
                return InstituteState.KB;
            case 4:
                return InstituteState.WR;
            case 5:
                return InstituteState.SinHan;
            case 6:
                return InstituteState.KoreaCity;
            case 7:
                return InstituteState.HaNa;
            case 8:
                return InstituteState.NHandSH;
            case 9:
                return InstituteState.KEB;
            case 10:
                return InstituteState.ETCBank;
        }
        return null;
    }
}
