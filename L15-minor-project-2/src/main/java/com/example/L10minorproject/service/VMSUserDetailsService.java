package com.example.L10minorproject.service;

import com.example.L10minorproject.entity.User;
import com.example.L10minorproject.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class VMSUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User appUser = userRepo.findByEmail(username);
        if(appUser == null){
            throw new UsernameNotFoundException("User does not exist");
        }
        return appUser;
    }
}
