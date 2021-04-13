package com.example.kakaoPay.domain;

import javax.persistence.*;

@Entity
public class Institute {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated
    private InstituteState state;


}
