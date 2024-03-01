package com.example.L10minorproject.entity;

import com.example.L10minorproject.enums.VisitStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.Date;

@Setter
@Getter
@Entity
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private VisitStatus status;

    @Column(nullable = false)
    private String purpose;

    private Date inTime;

    private Date outTime;

    private String imageUrl;

    @Column(nullable = false)
    private Integer noOfPeople;

    @ManyToOne
    private Visitor visitor;

    @OneToOne
    @JoinColumn(name = "flat_id", unique = true)
    private Flat flat;

    @OneToOne
    private User createdBy;

    @OneToOne
    private User approvedBy;


    @CreationTimestamp
    private Date createdDate;

    @UpdateTimestamp
    private Date updatedDate;


}
