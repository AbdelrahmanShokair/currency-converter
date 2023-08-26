package com.example.currencyconversion.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CurrencyConversion",url = "https://v6.exchangerate-api.com/v6/ecf10bab01b34bf0de9636e1")
public interface CurrencyConversionClient {
    @GetMapping("/pair/{from}/{to}/{amount}")
    String getResult(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable double amount
    );

    @GetMapping("/pair/{from}/{to}")
    String getExchangeRate(
            @PathVariable String from,
            @PathVariable String to

    );

    @GetMapping("/latest/{from}")
    String getAllRates(
            @PathVariable String from
    );
}
