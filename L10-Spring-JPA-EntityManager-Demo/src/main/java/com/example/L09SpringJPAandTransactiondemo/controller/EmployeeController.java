package com.example.L09SpringJPAandTransactiondemo.controller;

import com.example.L09SpringJPAandTransactiondemo.dto.EmployeeDetailRequest;
import com.example.L09SpringJPAandTransactiondemo.entity.Branch;
import com.example.L09SpringJPAandTransactiondemo.entity.Employee;
import com.example.L09SpringJPAandTransactiondemo.exception.IdCardNotAllocatedException;
import com.example.L09SpringJPAandTransactiondemo.repo.EmployeeRepo;
import com.example.L09SpringJPAandTransactiondemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @GetMapping("/byEmail")
    public ResponseEntity<Employee> getEmpByEmail(@RequestParam String email){
        Employee employee = employeeService.getByEmail(email);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/byName")
    public ResponseEntity<List<Employee>> getEmpByName(@RequestParam String name){
        List<Employee> employeeList = employeeService.getByName(name);
        return ResponseEntity.ok(employeeList);
    }


    @GetMapping("/findAll")
    public ResponseEntity<Page<Employee>> findAllEmp(@RequestParam Integer pageNo, @RequestParam(name = "noOfResults") Integer pageSize){
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        Page<Employee> employeePage = employeeService.getAllEmp(pageable);
        return ResponseEntity.ok(employeePage);
    }

    @GetMapping("/getAll")
    ResponseEntity<List<Employee>> getAll(){
        return ResponseEntity.ok(employeeService.getAll());
    }
}
