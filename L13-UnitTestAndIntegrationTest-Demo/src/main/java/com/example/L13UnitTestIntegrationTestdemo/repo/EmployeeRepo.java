package com.example.L13UnitTestIntegrationTestdemo.repo;

import com.example.L13UnitTestIntegrationTestdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    Employee findByEmail(String email);
}
