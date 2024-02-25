package com.example.L09SpringJPAandTransactiondemo.service;

import com.example.L09SpringJPAandTransactiondemo.dto.EmployeeDetailRequest;
import com.example.L09SpringJPAandTransactiondemo.entity.Address;
import com.example.L09SpringJPAandTransactiondemo.entity.Branch;
import com.example.L09SpringJPAandTransactiondemo.entity.Employee;
import com.example.L09SpringJPAandTransactiondemo.exception.IdCardNotAllocatedException;
import com.example.L09SpringJPAandTransactiondemo.exception.LaptopNotAllocatedException;
import com.example.L09SpringJPAandTransactiondemo.repo.BranchRepo;
import com.example.L09SpringJPAandTransactiondemo.repo.EmployeeRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private BranchRepo branchRepo;

    private boolean isCardAllocated = true;

    private boolean isLaptopAllocated = true;


    public Page<Employee> getAllEmp(Pageable pageable){
//        return employeeRepo.findAll(Sort.by("name"));
        return employeeRepo.findAll(pageable);
    }

    @Transactional
    public Employee getById(Long id){
        Employee employee = employeeRepo.findById(id).get();
        employee = employeeRepo.findById(id).get();
        employee = employeeRepo.findById(id).get();
        employee = employeeRepo.findById(id).get();
        return employee;
    }

    public Employee getByEmail(String email){
        return employeeRepo.findByEmail(email);
    }

    public List<Employee> getByName(String name){
        return employeeRepo.findByName(name);
    }

    @Transactional(rollbackOn = {IdCardNotAllocatedException.class}, dontRollbackOn ={LaptopNotAllocatedException.class} )
    public Long createEmpTxn(EmployeeDetailRequest employeeReq) throws IdCardNotAllocatedException {
        Employee employee = new Employee(); //non valid state
        employee.setName(employeeReq.getEmpName());
        employee.setEmail(employeeReq.getEmpEmail());

        Address address = Address.builder()
                .line1(employeeReq.getLine1())
                .line2(employeeReq.getLine2())
                .city(employeeReq.getCity())
                .build();//valid state

        employee = employeeRepo.save(employee);
        employee.setAddress(address);
        Branch branch = branchRepo.findById(employeeReq.getBranchId()).get();
        employee.setBranch(branch);
        // allocate laptop
        if(!isLaptopAllocated){
            throw new LaptopNotAllocatedException("Laptop not allocated");
        }
        // allocate Id card
        if(!isCardAllocated){
            throw new IdCardNotAllocatedException("IdCard not allocated");
        }
        return employee.getId();
    }

    public Long createEmp(EmployeeDetailRequest employeeReq){
        Employee employee = new Employee(); //non valid state
        employee.setName(employeeReq.getEmpName());
        employee.setEmail(employeeReq.getEmpEmail());

        Address address = Address.builder()
                .line1(employeeReq.getLine1())
                .line2(employeeReq.getLine2())
                .city(employeeReq.getCity())
                .build();//valid state

        employee.setAddress(address);
        Branch branch = branchRepo.findById(employeeReq.getBranchId()).get();
        employee.setBranch(branch);
        employee = employeeRepo.save(employee);
        return employee.getId();
    }

    public List<Employee> getAll(){
        return employeeRepo.findAll();
    }
}
