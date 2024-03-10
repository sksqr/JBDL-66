package com.example.L14SpringSecuritydemo.repo;

import com.example.L14SpringSecuritydemo.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepo extends JpaRepository<AppUser,Long> {

    AppUser findByEmail(String email);
}
