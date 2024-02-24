package com.example.L09SpringJPAandTransactiondemo.exception;

public class LaptopNotAllocatedException extends RuntimeException{

    public LaptopNotAllocatedException(String message) {
        super(message);
    }
}
