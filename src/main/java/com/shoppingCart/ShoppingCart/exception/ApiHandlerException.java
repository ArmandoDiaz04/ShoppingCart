package com.shoppingCart.ShoppingCart.exception;


import com.shoppingCart.ShoppingCart.common.StandarizedApiExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ApiHandlerException {
    
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<StandarizedApiExceptionResponse> handleNotContentException(NoSuchElementException ex){
        StandarizedApiExceptionResponse response = new StandarizedApiExceptionResponse("Error de validacion","Error-SPMC0001",ex.getMessage());
        return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body(response);
    }

    @ExceptionHandler(InsufficientAuthenticationException.class)
    public ResponseEntity<StandarizedApiExceptionResponse> handleInsufficientAuthenticationException(InsufficientAuthenticationException ex){
        StandarizedApiExceptionResponse response = new StandarizedApiExceptionResponse("Error, insuficientes permisos","Error-SPMC0002",ex.getMessage());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }

    @ExceptionHandler(BusinessRuleException.class)
    public ResponseEntity<StandarizedApiExceptionResponse> handleBusinessRuleException(BusinessRuleException ex){
        StandarizedApiExceptionResponse response = new StandarizedApiExceptionResponse("Error durante la ejecucion","Error-SPMC0003",ex.getMessage());
        return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body(response);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandarizedApiExceptionResponse> handleResourceNotFoundException(ResourceNotFoundException ex){
        StandarizedApiExceptionResponse response = new StandarizedApiExceptionResponse("Error, recurso no encontrado","Error-SPMC0004",ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<StandarizedApiExceptionResponse> handleProductNotFoundException(ProductNotFoundException ex){
        StandarizedApiExceptionResponse response = new StandarizedApiExceptionResponse("Error, producto no encontrado","Error-SPMC0005",ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(InvalidParameterValueException.class)
    public ResponseEntity<StandarizedApiExceptionResponse> handleInvalidParameterValueException(InvalidParameterValueException ex){
        StandarizedApiExceptionResponse response = new StandarizedApiExceptionResponse("Error, parametro invalido  null","Error-SPMC0006",ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandarizedApiExceptionResponse> handleGenericException(Exception ex){
        StandarizedApiExceptionResponse response = new StandarizedApiExceptionResponse("Error","Error-SPMC0007",ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }


}

