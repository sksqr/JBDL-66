package com.example.L09SpringJPAandTransactiondemo.controller;

import com.example.L09SpringJPAandTransactiondemo.dto.EmployeeDetailRequest;
import com.example.L09SpringJPAandTransactiondemo.entity.Branch;
import com.example.L09SpringJPAandTransactiondemo.entity.Employee;
import com.example.L09SpringJPAandTransactiondemo.exception.IdCardNotAllocatedException;
import com.example.L09SpringJPAandTransactiondemo.repo.EmployeeRepo;
import com.example.L09SpringJPAandTransactiondemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    ResponseEntity<Long> createEmp(@RequestBody EmployeeDetailRequest request) throws IdCardNotAllocatedException {
        Long id = employeeService.createEmpTxn(request);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getBranchById(@PathVariable Long id){
        Employee employee = employeeService.getById(id);
        return ResponseEntity.ok(employee);
    }


    @GetMapping("/getAll")
    ResponseEntity<List<Employee>> getAll(){
        return ResponseEntity.ok(employeeService.getAll());
    }
}
