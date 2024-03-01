package com.example.bankingapp.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor

public class AccountException {

    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;



    //private final HttpStatus httpstatus;

//    public String getMessage() {
//        return message;
//    }
//
//    public Throwable getThrowable() {
//        return throwable;
//    }
//
//    public HttpStatus getHttpstatus() {
//        return httpstatus;
//    }
//
//
//
//    public AccountException(String message, Throwable throwable, HttpStatus httpstatus) {
//        this.message = message;
//        this.throwable = throwable;
//        this.httpstatus = httpstatus;
//    }


}
