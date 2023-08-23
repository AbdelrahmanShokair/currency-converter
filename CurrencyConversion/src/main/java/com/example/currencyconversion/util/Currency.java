package com.example.currencyconversion.util;

import java.util.stream.Collectors;

public enum Currency {

    USD("USD","https://api.exchangerate-api.com/flag-images/US.gif"),
    EUR("EUR","https://api.exchangerate-api.com/flag-images/EU.gif"),
    GBP("GBP","https://api.exchangerate-api.com/flag-images/GB.gif"),
    EGP("EGP","https://api.exchangerate-api.com/flag-images/EG.gif"),
    AED("AED","https://api.exchangerate-api.com/flag-images/AE.gif"),
    RSA("RSA","https://api.exchangerate-api.com/flag-images/SA.gif"),
    KWD("KWD","https://api.exchangerate-api.com/flag-images/KW.gif"),
    CHF("CHF","https://api.exchangerate-api.com/flag-images/CH.gif"),
    CAD("CAD","https://api.exchangerate-api.com/flag-images/CA.gif"),
    QAR("QAR","https://api.exchangerate-api.com/flag-images/QA.gif");
    private final String code;
    private final String flagUrl;

    Currency(String code, String flagUrl) {
        this.code = code;
        this.flagUrl = flagUrl;
    }
//    public String getAllCurrencies(){
//        return Currency.stream()
//                .map(currency -> String.format("{\"Currency\": \"%s\", \"Flag URL\": \"%s\"}", currency.getCode(), currency.getFlagUrl()))
//                .collect(Collectors.joining(",\n"));
//    }

    public String getCode() {
        return code;
    }

    public String getFlagUrl() {
        return flagUrl;
    }

}
