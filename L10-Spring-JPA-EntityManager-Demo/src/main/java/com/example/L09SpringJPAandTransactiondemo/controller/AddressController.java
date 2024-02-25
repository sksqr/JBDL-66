package com.example.L09SpringJPAandTransactiondemo.controller;

import com.example.L09SpringJPAandTransactiondemo.entity.Address;
import com.example.L09SpringJPAandTransactiondemo.service.AddressService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;
    @PostMapping
    public ResponseEntity<Long> createAddress(@RequestBody Address address){

        return ResponseEntity.ok(addressService.createAddress(address));
    }
}
/*
start transaction



commit
OR
rollback
 */