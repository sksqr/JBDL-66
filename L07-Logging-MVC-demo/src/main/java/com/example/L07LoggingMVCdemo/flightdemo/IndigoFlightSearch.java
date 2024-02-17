package com.example.L07LoggingMVCdemo.flightdemo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class IndigoFlightSearch implements FlightSearchInterface{
    @Override
    public String getFlights(String src, String dest) {
        return null;
    }
}
