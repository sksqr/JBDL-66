package com.example.L07LoggingMVCdemo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class AppController {
    private static Logger LOGGER = LoggerFactory.getLogger(AppController.class);

    @GetMapping("/hello")
    public String getData(@RequestParam(required = false) String name){

        LOGGER.info("Get request for hello API : {}",name);
        return "Hello"+name+" from "+Thread.currentThread().getName();
    }
}
