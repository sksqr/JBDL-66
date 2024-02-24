package com.example.L09SpringJPAandTransactiondemo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDetailRequest {
    private String empName;
    private String empEmail;
    private String line1;
    private String line2;
    private String city;
    private Long branchId;
}
