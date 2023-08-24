package com.example.currencyconversion.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CurrencyDto {
    private final String code;
    private final String flagUrl;
    private final String desc;
}
