package com.example.currencyconversion.controller;

import com.example.currencyconversion.dto.ConversionDto;
import com.example.currencyconversion.dto.CurrencyResponseDto;
import com.example.currencyconversion.dto.RateDto;
import com.example.currencyconversion.service.CurrencyConversionService;
import com.example.currencyconversion.validation.annotation.ValidCurrency;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/currency-conversions")
@Validated
public class CurrencyConversionController {
    private final CurrencyConversionService currencyConversionService;
    @GetMapping("/convert")
    public ResponseEntity<ConversionDto> convert(@RequestParam @ValidCurrency String from,
                                                 @RequestParam @ValidCurrency String to,
                                                 @RequestParam @Positive double amount){
        return ResponseEntity.status(HttpStatus.OK)
                .body(currencyConversionService.convert(from, to, amount));


    }

    @GetMapping("/compare")
    public ResponseEntity<List<ConversionDto>> compare(@RequestParam @ValidCurrency String from,
                                                       @RequestParam List<@ValidCurrency String> to,
                                                       @RequestParam @Positive double amount){

        return ResponseEntity.status(HttpStatus.OK)
                .body(currencyConversionService.compare(from, to,amount));
    }

    @GetMapping("/currencies")
    public ResponseEntity<List<CurrencyResponseDto>> getAllCurrencies(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(currencyConversionService.getAllCurrencies());
    }

    @GetMapping("/rates")
    public ResponseEntity<List<RateDto>> getAllRates(@RequestParam @ValidCurrency String from,
                                                     @RequestParam List<@ValidCurrency String> to){
        return ResponseEntity.status(HttpStatus.OK)
                .body(currencyConversionService.getAllRates(from,to));
    }
}
