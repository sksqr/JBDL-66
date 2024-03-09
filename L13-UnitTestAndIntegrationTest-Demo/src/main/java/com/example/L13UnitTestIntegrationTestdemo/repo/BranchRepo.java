package com.example.L13UnitTestIntegrationTestdemo.repo;


import com.example.L13UnitTestIntegrationTestdemo.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepo extends JpaRepository<Branch,Long> {
}
