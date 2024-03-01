package com.example.bankingapp.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalAccountExceptionHandler {

    @ExceptionHandler(value = {AccountNotFoundException.class})
    public ResponseEntity<Object> handleAccountNotFoundException
            (AccountNotFoundException accountNotFoundException)
    {
        AccountException accountException = new AccountException(
                accountNotFoundException.getMessage(),
                accountNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );

        return new ResponseEntity<>(accountException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach((error)->{
            errorMap.put(error.getField(), error.getDefaultMessage());

        });

        return new ResponseEntity<Map<String,String>>(errorMap,HttpStatus.BAD_REQUEST );


        //return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST );
    }

}
