package com.example.L10minorproject.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
public class Address {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String line1;

    private String line2;

    private String city;

    private String pincode;

    private String country;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private OffsetDateTime createdDate;

    @LastModifiedDate
    @Column(nullable = false)
    private OffsetDateTime updatedDate;
}
