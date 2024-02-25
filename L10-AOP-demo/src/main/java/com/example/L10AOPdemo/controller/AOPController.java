package com.example.L10AOPdemo.controller;

import com.example.L10AOPdemo.service.AOPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AOPController {

    @Autowired
    private AOPService aopService;

    @GetMapping
    public ResponseEntity<String> getMsg(){
//        return ResponseEntity.ok(aopService.getHelloMsg());

        return ResponseEntity.ok(aopService.getHiMsg());
    }



}
