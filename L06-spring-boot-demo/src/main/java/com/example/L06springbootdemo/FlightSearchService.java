package com.example.L06springbootdemo;

import org.springframework.beans.factory.annotation.Value;

public class FlightSearchService {

    @Value("${indigo.url}")
    private String indigoUrl;

    public void callIndo(){

    }
}
