package com.example.currencyconversion.validation.annotation;

import com.example.currencyconversion.validation.CurrencyValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CurrencyValidator.class)
@Target({ElementType.TYPE_USE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCurrency {
    String message() default "Invalid Currency";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
