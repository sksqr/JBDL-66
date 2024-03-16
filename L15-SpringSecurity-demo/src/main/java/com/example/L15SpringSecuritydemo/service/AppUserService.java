package com.example.L15SpringSecuritydemo.service;

import com.example.L15SpringSecuritydemo.entity.AppUser;
import com.example.L15SpringSecuritydemo.repo.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {

    @Autowired
    private AppUserRepo appUserRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Long createUser(AppUser appUser){
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        appUser = appUserRepo.save(appUser);
        return appUser.getId();
    }

    public boolean changePassword(AppUser appUser, String newPassword){
        appUser.setPassword(passwordEncoder.encode(newPassword));
        appUser = appUserRepo.save(appUser);
        return true;
    }
}
