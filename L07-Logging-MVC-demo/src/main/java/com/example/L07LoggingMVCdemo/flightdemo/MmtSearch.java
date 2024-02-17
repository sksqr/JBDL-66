package com.example.L07LoggingMVCdemo.flightdemo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MmtSearch {

//    @Autowired
//    @Qualifier("airIndiaFlightSearch")
//    private FlightSearchInterface flightSearchAir;

    @Autowired
    private FlightSearchInterface flightSearch;

    @PostConstruct
    public void initMethod(){
        /*

         */
    }


    public String getFlights(String src, String dest) {
        return flightSearch.getFlights(src,dest);
    }



}
