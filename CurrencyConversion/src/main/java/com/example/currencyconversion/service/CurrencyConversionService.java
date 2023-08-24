package com.example.currencyconversion.service;

import com.example.currencyconversion.dto.ConversionDto;
import com.example.currencyconversion.dto.CurrencyDto;
import com.example.currencyconversion.dto.RateDto;

import java.util.List;

public interface CurrencyConversionService {
    ConversionDto convert(String from,String to, double amount);
    ConversionDto getRate(String from,String to);
    List<CurrencyDto> getAllCurrencies();

    List<RateDto> getAllRates(String from, List<String> to);
}
