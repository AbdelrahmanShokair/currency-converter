package com.example.currencyconversion.service;

import com.example.currencyconversion.dto.ConversionDto;
import com.example.currencyconversion.dto.RateDto;
import com.example.currencyconversion.util.Currency;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Arrays;
import java.util.List;


@SpringBootTest
@EnableFeignClients(basePackages = {"com.example.currencyconversion.client"})
public class CurrencyConversionServiceTest {
    @Autowired
    private CurrencyConversionService currencyConversionService;
    @Test
    public void getRatesTest(){
        String baseCurrency = "USD";
        List<String> targetCurrencies = Arrays.asList("EUR","GBP","EGP","AED","SAR","KWD","CHF","CAD","QAR");
        List<RateDto> allRates = this.currencyConversionService.getAllRates(baseCurrency, targetCurrencies);
        System.out.println("target Currencies : "+ targetCurrencies.stream().count());
        long conversionDtosCount = allRates.stream().map(rate -> {
            return rate.getRate();
        }).count();
        System.out.println("Rates Currencies : "+ conversionDtosCount);
        Assertions.assertThat(conversionDtosCount).isEqualTo(targetCurrencies.stream().count());

        Assertions.assertThat(allRates.stream().map(fromCurrency -> {
            return fromCurrency.getFrom();
        })).allMatch(s -> s.equals(baseCurrency));
    }

    @Test
    public void getAllCurrenciesTest(){
        Assertions.assertThat(this.currencyConversionService.getAllCurrencies().stream().count())
                .isEqualTo(Arrays.stream(Currency.values()).count());

    }

    @Test
    public void compareTest(){
        String baseCurrency = "USD";
        List<String> targetCurrencies = Arrays.asList("EUR","GBP","EGP","AED","SAR","KWD","CHF","CAD","QAR");
        List<ConversionDto> allResults = this.currencyConversionService.compare(baseCurrency, targetCurrencies,100);
        System.out.println("target Currencies : "+ targetCurrencies.stream().count());
        long conversionDtosCount = allResults.stream().map(value -> {
            return value.getValue();
        }).count();
        System.out.println("Results Amount Currencies : "+ conversionDtosCount);
        Assertions.assertThat(conversionDtosCount).isEqualTo(targetCurrencies.stream().count());

        Assertions.assertThat(allResults.stream().map(fromCurrency -> {
            return fromCurrency.getFrom();
        })).allMatch(s -> s.equals(baseCurrency));

    }

    @Test
    public void convertTest(){
        String from = "USD";
        String to = "USD";
        double amount = 100;
        ConversionDto result = this.currencyConversionService.convert(from, to,amount);
        Assertions.assertThat(result.getFrom()).isEqualTo(from);
        Assertions.assertThat(result.getTo()).isEqualTo(to);
        Assertions.assertThat(result.getValue()).isEqualTo(amount);

    }
}
