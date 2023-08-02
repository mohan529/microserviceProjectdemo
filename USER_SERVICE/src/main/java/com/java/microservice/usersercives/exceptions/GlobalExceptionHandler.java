package com.java.microservice.usersercives.exceptions;

import com.java.microservice.usersercives.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException ex){

        String message=ex.getMessage();
        ApiResponse apiResponse=ApiResponse.builder().msg(message).status(HttpStatus.NOT_FOUND).success(true).build();
         return  ResponseEntity.ok(apiResponse);
    }

}
