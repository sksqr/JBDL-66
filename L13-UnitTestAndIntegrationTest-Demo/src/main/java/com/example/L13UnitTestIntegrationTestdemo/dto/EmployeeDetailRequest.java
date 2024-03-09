package com.example.L13UnitTestIntegrationTestdemo.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDetailRequest {
    private String empName;
    private String empEmail;
    private String line1;
    private String line2;
    private String city;
    private Long branchId;
}
