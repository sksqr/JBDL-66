package com.gfg.flightdemo;

import java.util.List;

public interface AirlineFlightSearchInterface {
    List<FlightData> getFlightBySrcDes(String src, String des);
}
