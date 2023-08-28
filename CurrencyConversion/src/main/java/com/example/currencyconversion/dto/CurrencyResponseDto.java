package com.example.currencyconversion.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class CurrencyResponseDto implements Serializable {
    private final String code;
    private final String flagUrl;
    private final String desc;
}
