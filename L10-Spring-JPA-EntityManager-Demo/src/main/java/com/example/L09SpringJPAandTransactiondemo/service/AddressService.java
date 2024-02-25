package com.example.L09SpringJPAandTransactiondemo.service;

import com.example.L09SpringJPAandTransactiondemo.entity.Address;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AddressService {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Long createAddress( Address address){
        entityManager.persist(address);
        return address.getId();
    }
}
