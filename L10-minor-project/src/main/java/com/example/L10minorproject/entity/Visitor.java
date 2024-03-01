package com.example.L10minorproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.OffsetDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
public class Visitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String phone;

    @Column(nullable = false, unique = true)
    private String idNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    private Address address;

    @OneToMany
    private Set<Visit> visitSet;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private OffsetDateTime createdDate;

    @LastModifiedDate
    @Column(nullable = false)
    private OffsetDateTime updatedDate;
}
