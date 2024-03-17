package com.example.L16OAuth2demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepo extends JpaRepository<MyUser,Long> {

    MyUser findByEmail(String email);
}
