package com.example.currencyconversion.service.impl;

import com.example.currencyconversion.client.CurrencyConversionClient;
import com.example.currencyconversion.dto.ConversionDto;
import com.example.currencyconversion.dto.CurrencyResponseDto;
import com.example.currencyconversion.dto.RateDto;
import com.example.currencyconversion.service.CurrencyConversionService;
import com.example.currencyconversion.util.Currency;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@CacheConfig(cacheNames = {"CurrencyConversion"})
public class CurrencyConversionServiceImpl implements CurrencyConversionService {
    private final CurrencyConversionClient currencyConversionClient;

    @Override
    public ConversionDto convert(String from, String to, double amount) {
        String responseBody = currencyConversionClient.convert(from, to, amount);
        JsonObject jsonResponse = JsonParser.parseString(responseBody).getAsJsonObject();
        JsonElement data = jsonResponse.get("conversion_result");
        double conversionResult = data.getAsDouble();
        return new ConversionDto(from,to,conversionResult);
    }
    @Override
    public List<ConversionDto> compare(String from, List<String> to,double amount) {

        List<RateDto> rates = getAllRates(from, to);
        return rates.stream().map(rate -> {
             return new ConversionDto(from, rate.getTo(), rate.getRate()*amount);
        }).toList();
    }
    @Override
    @Cacheable(value = "getAllCurrencies",key = "#root.methodName")
    public List<CurrencyResponseDto> getAllCurrencies() {
        return Arrays.stream(Currency.values())
                .map(currency -> new CurrencyResponseDto(currency.getCode(), currency.getFlagUrl(), currency.getDesc())).toList();
    }
    @Override
    @Cacheable(value = "getAllRates",key = "#from+#to")
    public List<RateDto> getAllRates(String from, List<String> to) {
        String responseBody = currencyConversionClient.getAllRates(from);
        JsonObject jsonResponse = JsonParser.parseString(responseBody).getAsJsonObject();
        JsonObject data = jsonResponse.getAsJsonObject("conversion_rates");
        return to.stream()
                .filter(currency -> data.has(currency))
                .map(targetCurrency -> {
                return new RateDto(from,targetCurrency,data.get(targetCurrency).getAsDouble());
        }).toList();
    }
}
