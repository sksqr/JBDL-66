package com.gfg.flightdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MmtSearchService {

    private ExecutorService executorService;
    private List<AirlineFlightSearchInterface> flightSearchServices;

    public MmtSearchService(List<AirlineFlightSearchInterface> flightSearchServices) {
        this.flightSearchServices = flightSearchServices;
        executorService = Executors.newFixedThreadPool(10);
    }

    public List<FlightData> getFlightDataFromSrcDes(String src, String des){
        List<FlightData> finalResponse = new ArrayList<>();
        for(AirlineFlightSearchInterface searchService : flightSearchServices ){
            finalResponse.addAll(searchService.getFlightBySrcDes(src,des));
        }
        return finalResponse;
    }

    public List<FlightData> getFlightDataFromSrcDesMultiThreading(String src, String des){
        List<FlightData> finalResponse = new ArrayList<>();
        List<Callable<List<FlightData>>> callableTaskList = new ArrayList<>();
        for(AirlineFlightSearchInterface searchService : flightSearchServices ){
            callableTaskList.add(new Callable<List<FlightData>>() {
                @Override
                public List<FlightData> call() throws Exception {
                    return searchService.getFlightBySrcDes(src,des);
                }
            });
        }
        try {
            List<Future<List<FlightData>>> listFuture = executorService.invokeAll(callableTaskList);
            for (Future<List<FlightData>> future : listFuture){
                finalResponse.addAll(future.get());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        return finalResponse;

    }
}
