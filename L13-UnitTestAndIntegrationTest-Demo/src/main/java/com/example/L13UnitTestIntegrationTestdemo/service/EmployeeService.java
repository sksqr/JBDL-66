package com.example.L13UnitTestIntegrationTestdemo.service;


import com.example.L13UnitTestIntegrationTestdemo.dto.EmployeeDetailRequest;
import com.example.L13UnitTestIntegrationTestdemo.entity.Address;
import com.example.L13UnitTestIntegrationTestdemo.entity.Branch;
import com.example.L13UnitTestIntegrationTestdemo.entity.Employee;
import com.example.L13UnitTestIntegrationTestdemo.exception.IdCardNotAllocatedException;
import com.example.L13UnitTestIntegrationTestdemo.exception.LaptopNotAllocatedException;
import com.example.L13UnitTestIntegrationTestdemo.repo.BranchRepo;
import com.example.L13UnitTestIntegrationTestdemo.repo.EmployeeRepo;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private static Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

//    @Autowired
    private EmployeeRepo employeeRepo;


    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    private boolean isCardAllocated = true;

    private boolean isLaptopAllocated = true;


    public Employee getById(Long id){
        Employee employee = employeeRepo.findById(id).get();
        return employee;
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

        employee.setAddress(address);
        employee = employeeRepo.save(employee);
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

    public Employee createEmp(EmployeeDetailRequest employeeReq){
        Employee employee = new Employee(); //non valid state
        employee.setName(employeeReq.getEmpName());
        employee.setEmail(employeeReq.getEmpEmail());

        Address address = Address.builder()
                .line1(employeeReq.getLine1())
                .line2(employeeReq.getLine2())
                .city(employeeReq.getCity())
                .build();//valid state

        employee.setAddress(address);
        employee = employeeRepo.save(employee);
        LOGGER.info("Employee Created");
        return employee;
    }

    public List<Employee> getAll(){
        return employeeRepo.findAll();
    }
}
