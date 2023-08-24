package com.example.currencyconversion.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConversionDto {
    private  String from;
    private String to;
    @Positive
    @Digits(integer = 3,fraction = 1)
    private double value;
}
