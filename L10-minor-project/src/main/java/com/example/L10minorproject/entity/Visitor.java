package com.example.L10minorproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
public class Visitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String phone;

    private String idNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    private Address address;

    @OneToMany
    private Set<Visit> visitSet;
}
