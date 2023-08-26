package com.example.currencyconversion.exception;

import com.example.currencyconversion.dto.ErrorDto;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Path;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        log.error("MethodArgumentNotValidException class=" + ex.getClass() + ", status=BAD_REQUEST(400)");
        Map<String, String> result = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach(error -> {
                    String field = ((FieldError) error).getField();
                    String message = error.getDefaultMessage();
                    result.put(field, message);
                }
        );
        return ResponseEntity.badRequest().body(result);
    }
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex, WebRequest request) {
        log.error("ConstraintViolationException class=" + ex.getClass() + ", status=BAD_REQUEST(400)");
        System.out.println(ex.getClass());
        Map<Path, String> result = new HashMap<>();
        ex.getConstraintViolations().forEach(constraintViolation -> {
            result.put(constraintViolation.getPropertyPath(), constraintViolation.getMessage());
        });
        return ResponseEntity.badRequest().body(result);
    }


    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorDto> handleCustomException(CustomException ex, WebRequest request) {
        log.error("CustomException status=" + ex.getHttpStatus().toString() + "("
                + ex.getHttpStatus().value() + "), message=" + ex.getMessage());
        ErrorDto errorDto = new ErrorDto(ex.getMessage(), ex.getHttpStatus().value());
        return new ResponseEntity<>(errorDto, ex.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> handleGlobalException(Exception ex, WebRequest request) {
        log.error("Generic Exception class=" + ex.getClass() + ", status=INTERNAL_SERVER_ERROR(500)" +
                ", message=" + ex.getMessage());
        ErrorDto errorDto = new ErrorDto(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
