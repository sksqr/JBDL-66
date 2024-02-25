package com.example.L10AOPdemo.service;

import com.example.L10AOPdemo.aspect.LogExecutionTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AOPService {

    private static Logger LOGGER = LoggerFactory.getLogger(AOPService.class);


    public String getHelloMsg(){
        LOGGER.info("Inside getHelloMsg");
        return "Hello from :"+Thread.currentThread().getName();
    }


    @LogExecutionTime
    public String getHiMsg(){
        LOGGER.info("Inside getHiMsg");
        return "Hi! from :"+Thread.currentThread().getName();
    }
}
