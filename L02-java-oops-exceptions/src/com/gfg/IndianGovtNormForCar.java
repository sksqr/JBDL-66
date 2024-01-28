package com.gfg;

public interface IndianGovtNormForCar {

    String getInsurance();

    String getRC();

    default String getLocation(){
        return "NA";
    }
}
