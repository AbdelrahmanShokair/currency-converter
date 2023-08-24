package com.example.currencyconversion.controller;

import com.example.currencyconversion.dto.ConversionDto;
import com.example.currencyconversion.dto.CurrencyDto;
import com.example.currencyconversion.dto.RateDto;
import com.example.currencyconversion.service.CurrencyConversionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/currency-conversions")
public class CurrencyConversionController {
    private final CurrencyConversionService currencyConversionService;
    @GetMapping("/convert/{from}/{to}/{amount}")
    public ResponseEntity<ConversionDto> convert(@PathVariable String from,
                                                 @PathVariable String to,
                                                 @PathVariable double amount){
        return ResponseEntity.status(HttpStatus.OK)
                .body(currencyConversionService.convert(from, to, amount));
    }

    @GetMapping("/compare")
    public ResponseEntity<List<ConversionDto>> getRate(@RequestParam String from, @RequestParam List<String> to,@RequestParam double amount){

        return ResponseEntity.status(HttpStatus.OK)
                .body(currencyConversionService.compare(from, to,amount));
    }

    @GetMapping("/currencies")
    public ResponseEntity<List<CurrencyDto>> getAllCurrencies(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(currencyConversionService.getAllCurrencies());
    }

    @GetMapping("/rates")
    public ResponseEntity<List<RateDto>> getAllRates(@RequestParam String from, @RequestParam List<String> to){
        return ResponseEntity.status(HttpStatus.OK)
                .body(currencyConversionService.getAllRates(from,to));
    }
}
