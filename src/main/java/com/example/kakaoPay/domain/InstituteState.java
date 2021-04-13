package com.example.kakaoPay.domain;

public enum InstituteState {
    City("주택도시기금", "BANK01"),
    KB("국민은행", "BANK02"),
    WR("우리은행", "BANK03"),
    KoreaCity("한국은행", "BANK04"),
    HaNa("하나은행", "BANK05"),
    NHandSH("농협은행/수협은행", "BANK06"),
    KEB("외한은행", "BANK07"),
    ETCBank("기타은행", "BANK100");

    private String name;
    private String code;

    InstituteState(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
