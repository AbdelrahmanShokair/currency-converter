package com.example.currencyconversion.dto;

import com.example.currencyconversion.validation.annotation.ValidCurrency;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CurrencyRequestDto {
    @ValidCurrency
    private String currencyCode;
}
