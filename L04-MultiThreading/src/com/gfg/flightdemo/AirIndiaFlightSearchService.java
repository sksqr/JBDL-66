package com.gfg.flightdemo;

import java.util.ArrayList;
import java.util.List;

public class AirIndiaFlightSearchService implements AirlineFlightSearchInterface{
    @Override
    public List<FlightData> getFlightBySrcDes(String src, String des) {
        // call API air india
        // convert data to FlightData
        List<FlightData> response = new ArrayList<>();
        response.add(new FlightData("DLI","BLR",25000.00));
        response.add(new FlightData("DLI","BLR",26000.00));
        return response;
    }
}
