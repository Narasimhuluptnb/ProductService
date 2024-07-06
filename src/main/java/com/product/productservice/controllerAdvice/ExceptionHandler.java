package com.product.productservice.controllerAdvice;

import com.product.productservice.dtos.ExceptionDto;
import com.product.productservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<String> ArithmeticExceptionHandler(){
        ResponseEntity<String> response = new ResponseEntity<>("Arithmetic Exception! try after some time", HttpStatus.NOT_FOUND);
    return response;
    }
    // We can give object also
    @org.springframework.web.bind.annotation.ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ExceptionDto> NullPointerException(){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setIssue("NullPointerException");
        exceptionDto.setSolution("Please try after some time! Team working on the Fix");
        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
        return response;
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDto> ProductNotFoundException(){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setIssue("ProductNotFoundException");
        exceptionDto.setSolution("Please try after some time! Working on Fix");
        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
        return response;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<String> ArrayIndexOutOfException(){
        ResponseEntity<String> response = new ResponseEntity<>("ArrayIndexOutOfBoundsException! try after some time", HttpStatus.NOT_FOUND);
        return response;
    }


}
