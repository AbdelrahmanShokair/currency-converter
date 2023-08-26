package com.example.currencyconversion.validation;

import com.example.currencyconversion.util.Currency;
import com.example.currencyconversion.validation.annotation.ValidCurrency;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CurrencyValidator implements ConstraintValidator<ValidCurrency,String> {
    private final List<String> allowedCurrency = Arrays
            .stream(Currency.values())
            .map(Currency::getCode)
            .toList();

    @Override
    public boolean isValid(String currencyCode, ConstraintValidatorContext constraintValidatorContext) {
        return currencyCode != null && allowedCurrency.contains(currencyCode);
    }
}
