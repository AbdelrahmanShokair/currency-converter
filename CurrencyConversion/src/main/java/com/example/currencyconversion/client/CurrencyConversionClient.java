package com.example.currencyconversion.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CurrencyConversion",url = "${currency.conversion.api.url}${currency.conversion.api.key}")
public interface CurrencyConversionClient {

    @GetMapping("/pair/{from}/{to}/{amount}")
    String convert(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable double amount
    );
    @GetMapping("/latest/{from}")
    String getAllRates(
            @PathVariable String from
    );
}
