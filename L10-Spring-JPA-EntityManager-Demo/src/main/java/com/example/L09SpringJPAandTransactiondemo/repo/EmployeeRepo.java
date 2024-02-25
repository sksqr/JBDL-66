package com.example.L09SpringJPAandTransactiondemo.repo;

import com.example.L09SpringJPAandTransactiondemo.entity.Branch;
import com.example.L09SpringJPAandTransactiondemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    public Employee findByEmail(String email);

    public List<Employee> findByName(String name);

    public List<Employee> findByNameAndBranch(String name, Branch branch);


    @Query(value = "Select * from employee where branch_id=:id", nativeQuery = true)
    public List<Employee> findByBranchId(Long id);
}
