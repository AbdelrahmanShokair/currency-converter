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
    public List<ConversionDto> compare(String from, List<String> to,double amount) {

        List<RateDto> rates = getAllRates(from, to);
        return rates.stream().map(rate -> {
             return new ConversionDto(from, rate.getTo(), rate.getRate()*amount);
        }).toList();
    }

    @Override
    public List<CurrencyDto> getAllCurrencies() {
        return Arrays.stream(Currency.values())
                .map(currency -> new CurrencyDto(currency.getCode(), currency.getFlagUrl(), currency.getDesc())).toList();
    }

    @Override
    public List<RateDto> getAllRates(String from, List<String> to) {
//        return to.stream().map(targetCurrency -> {
//            String responseBody = currencyConversionClient.getExchangeRate(from,targetCurrency);
//            JsonObject jsonResponse = JsonParser.parseString(responseBody).getAsJsonObject();
//            JsonElement data = jsonResponse.get("conversion_rate");
//            return new RateDto(from,targetCurrency,data.getAsDouble());
//        }).toList();
        //eshtghal
        String responseBody = currencyConversionClient.getAllRates(from);
        JsonObject jsonResponse = JsonParser.parseString(responseBody).getAsJsonObject();
        JsonObject data = jsonResponse.getAsJsonObject("conversion_rates");
        return to.stream().map(targetCurrency -> {
            if (data.has(targetCurrency) == true){
                return new RateDto(from,targetCurrency,data.get(targetCurrency).getAsDouble());
            }else {
                return null;
            }
        }).toList();

    }
}
