package com.gfg.flightdemo;

import java.util.ArrayList;
import java.util.List;

public class IndigoFlightSearchService implements AirlineFlightSearchInterface{
    @Override
    public List<FlightData> getFlightBySrcDes(String src, String des) {
        // call API indigo
        // convert data to FlightData
        List<FlightData> response = new ArrayList<>();
        response.add(new FlightData("DLI","BLR",5000.00));
        response.add(new FlightData("DLI","BLR",6000.00));
        return response;
    }
}
