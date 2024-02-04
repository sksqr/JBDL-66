package com.gfg.flightdemo;

import java.util.ArrayList;
import java.util.List;

public class GoAirFlightSearchService implements AirlineFlightSearchInterface{
    @Override
    public List<FlightData> getFlightBySrcDes(String src, String des) {
        // call API goAir
        // convert data to FlightData
        List<FlightData> response = new ArrayList<>();
        response.add(new FlightData("DLI","BLR",15000.00));
        response.add(new FlightData("DLI","BLR",16000.00));
        return response;
    }
}
