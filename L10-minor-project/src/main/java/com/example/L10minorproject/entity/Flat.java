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
public class Flat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String number;

    @OneToMany(mappedBy = "flat")
    private Set<User> users;


    @CreatedDate
    @Column(nullable = false, updatable = false)
    private OffsetDateTime createdDate;

    @LastModifiedDate
    @Column(nullable = false)
    private OffsetDateTime updatedDate;
}
