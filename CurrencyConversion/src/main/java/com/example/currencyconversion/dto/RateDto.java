package com.example.currencyconversion.dto;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RateDto implements Serializable {
    private  String from;
    private String to;
    @Positive
    private double rate;
}
