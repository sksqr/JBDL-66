package com.example.L10minorproject.exception;

public class BadRequestException  extends RuntimeException{

    public BadRequestException() {
    }

    public BadRequestException(String message) {
        super(message);
    }
}
