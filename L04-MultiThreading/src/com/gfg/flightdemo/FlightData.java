package com.gfg.flightdemo;

public class FlightData {
    private String src;

    private String des;

    private Double cost;

    public FlightData(String src, String des, Double cost) {
        this.src = src;
        this.des = des;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "FlightData{" +
                "src='" + src + '\'' +
                ", des='" + des + '\'' +
                ", cost=" + cost +
                '}';
    }
}
