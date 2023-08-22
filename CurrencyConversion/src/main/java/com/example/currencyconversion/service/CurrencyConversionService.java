package com.example.currencyconversion.service;

import com.example.currencyconversion.dto.ConversionDto;
import com.example.currencyconversion.util.Currencies;
import com.google.gson.JsonObject;

import java.util.List;
import java.util.Set;

public interface CurrencyConversionService {
    ConversionDto convert(String from,String to, double amount);
    ConversionDto getRate(String from,String to);
    Currencies[] getAllCurrencies();

    String getAllRates(String from);
}
