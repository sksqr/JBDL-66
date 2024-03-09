package com.example.L13UnitTestIntegrationTestdemo.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "branch", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("branch")
    private Set<Employee> employeeSet;


}
/*
@Transaction
branch from DB
---
---
---
--
branch.getEmployeeSet()
 */