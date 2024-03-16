package com.example.L15SpringSecuritydemo.repo;

import com.example.L15SpringSecuritydemo.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepo extends JpaRepository<AppUser,Long> {

    AppUser findByEmail(String email);
}
