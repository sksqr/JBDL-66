package com.example.L09SpringJPAandTransactiondemo.repo;

import com.example.L09SpringJPAandTransactiondemo.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepo extends JpaRepository<Branch,Long> {
}
