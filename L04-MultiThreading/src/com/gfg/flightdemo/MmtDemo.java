package com.gfg.flightdemo;

import java.util.ArrayList;
import java.util.List;

public class MmtDemo {

    public static void main(String[] args) {

        List<AirlineFlightSearchInterface> flightSearchServices = new ArrayList<>();
        flightSearchServices.add(new GoAirFlightSearchService());
        flightSearchServices.add(new IndigoFlightSearchService());
        flightSearchServices.add(new AirIndiaFlightSearchService());

        MmtSearchService mmtSearchService = new MmtSearchService(flightSearchServices);
//        List<FlightData> response = mmtSearchService.getFlightDataFromSrcDes("DLI","BLR");
        List<FlightData> response = mmtSearchService.getFlightDataFromSrcDesMultiThreading("DLI","BLR");
        System.out.println(response);
    }
}
