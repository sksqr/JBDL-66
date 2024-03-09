package com.example.L13UnitTestIntegrationTestdemo.repo;

import com.example.L13UnitTestIntegrationTestdemo.dto.EmployeeDetailRequest;
import com.example.L13UnitTestIntegrationTestdemo.entity.Address;
import com.example.L13UnitTestIntegrationTestdemo.entity.Employee;
import com.example.L13UnitTestIntegrationTestdemo.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class EmployeeRepoTest {
    @Autowired
    private EmployeeRepo employeeRepo;
    private Employee employee;

    @BeforeEach
    public void setup() {

        Address address = Address.builder()
                .id(1l)
                .line1("A-1")
                .line2("Sector-10")
                .city("Delhi")
                .build();

        employee = Employee.builder()
                .id(50l)
                .email("emp1@yopmail.com")
                .name("Rahul")
                .address(address)
                .build();
        employeeRepo.save(employee);
    }

    @Test
    public void testFindByEmail(){
        Employee actual = employeeRepo.findByEmail("emp1@yopmail.com");
        assertThat(actual).isEqualTo(employee);
    }
}
