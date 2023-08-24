package com.example.currencyconversion.service.impl;

import com.example.currencyconversion.client.CurrencyConversionClient;
import com.example.currencyconversion.dto.ConversionDto;
import com.example.currencyconversion.dto.CurrencyDto;
import com.example.currencyconversion.dto.RateDto;
import com.example.currencyconversion.service.CurrencyConversionService;
import com.example.currencyconversion.util.Currency;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyConversionServiceImpl implements CurrencyConversionService {
    private final CurrencyConversionClient currencyConversionClient;


    @Override
    public ConversionDto convert(String from, String to, double amount) {
        String responseBody = currencyConversionClient.getResult(from, to, amount);
        JsonObject jsonResponse = JsonParser.parseString(responseBody).getAsJsonObject();
        JsonElement data = jsonResponse.get("conversion_result");
        double conversionResult = data.getAsDouble();
        return new ConversionDto(from,to,conversionResult);
    }

    @Override
    public ConversionDto getRate(String from, String to) {
        String responseBody = currencyConversionClient.getExchangeRate(from, to);
        JsonObject jsonResponse = JsonParser.parseString(responseBody).getAsJsonObject();
        JsonElement data = jsonResponse.get("conversion_rate");
        double conversionResult = data.getAsDouble();
        return new ConversionDto(from,to,conversionResult);
    }

    @Override
    public List<CurrencyDto> getAllCurrencies() {
        return Arrays.stream(Currency.values())
                .map(currency -> new CurrencyDto(currency.getCode(), currency.getFlagUrl(), currency.getDesc())).toList();
    }

    @Override
    public List<RateDto> getAllRates(String from, List<String> to) {
        return to.stream().map(targetCurrency -> {
            String responseBody = currencyConversionClient.getExchangeRate(from,targetCurrency);
            JsonObject jsonResponse = JsonParser.parseString(responseBody).getAsJsonObject();
            JsonElement data = jsonResponse.get("conversion_rate");
            return new RateDto(from,targetCurrency,data.getAsDouble());
        }).toList();

    }
}
