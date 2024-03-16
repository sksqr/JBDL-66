package com.example.L15SpringSecuritydemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {




    @GetMapping
    public String getHelloApp(){
        return "Hello Public User!! from "+Thread.currentThread().getName();
    }
}
