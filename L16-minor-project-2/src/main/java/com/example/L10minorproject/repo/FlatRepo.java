package com.example.L10minorproject.repo;

import com.example.L10minorproject.entity.Flat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlatRepo extends JpaRepository<Flat, Long> {
    Flat findByNumber(String number);
}
