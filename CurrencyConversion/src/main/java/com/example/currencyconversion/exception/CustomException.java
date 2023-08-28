package com.example.currencyconversion.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomException extends RuntimeException{
    public CustomException(String message, String message1) {
        super(message);
        this.message = message1;
    }

    private String message;
    private HttpStatus httpStatus;
}
