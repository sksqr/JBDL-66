package com.example.L10minorproject.entity;

import com.example.L10minorproject.enums.VisitStatus;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.Date;

public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private VisitStatus status;

    private String purpose;

    private Date inTime;

    private Date outTime;

    private String imageUrl;

    private Integer noOfPeople;

    @ManyToOne
    private Visitor visitor;

    @OneToOne
    private Flat flat;

    @OneToOne
    private User createdBy;

    @OneToOne
    private User approvedBy;


}
