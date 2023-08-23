package com.example.currencyconversion.service.impl;

import com.example.currencyconversion.client.CurrencyConversionClient;
import com.example.currencyconversion.dto.ConversionDto;
import com.example.currencyconversion.service.CurrencyConversionService;
import com.example.currencyconversion.util.Currency;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
        return new ConversionDto(conversionResult);
    }

    @Override
    public ConversionDto getRate(String from, String to) {
        String responseBody = currencyConversionClient.getExchangeRate(from, to);
        JsonObject jsonResponse = JsonParser.parseString(responseBody).getAsJsonObject();
        JsonElement data = jsonResponse.get("conversion_rate");
        double conversionResult = data.getAsDouble();
        return new ConversionDto(conversionResult);
    }

    @Override
    public String getAllCurrencies() {
//        return Currency.stream()
//                .map(currency -> String.format("{\"Currency\": \"%s\", \"Flag URL\": \"%s\"}", currency.getCode(), currency.getFlagUrl()))
//                .collect(Collectors.joining(",\n"));
        return "{\n"+Arrays.stream(Currency.values())
                .map(currency -> String.format("{\"Currency\": \"%s\", \"Flag URL\": \"%s\"}", currency.getCode(), currency.getFlagUrl()))
                .collect(Collectors.joining(",\n"))+"\n}";
    }

    @Override
    public String getAllRates(String from) {
        String responseBody = currencyConversionClient.getAllRates(from);
        JsonObject jsonResponse = JsonParser.parseString(responseBody).getAsJsonObject();
        JsonObject data = jsonResponse.getAsJsonObject("conversion_rates");
        return data.toString();
    }
}
