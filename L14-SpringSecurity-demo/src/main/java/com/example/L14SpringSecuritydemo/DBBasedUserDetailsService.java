package com.example.L14SpringSecuritydemo;

import com.example.L14SpringSecuritydemo.entity.AppUser;
import com.example.L14SpringSecuritydemo.repo.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class DBBasedUserDetailsService implements UserDetailsService {

    @Autowired
    private AppUserRepo appUserRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepo.findByEmail(username);
        if(appUser == null){
            throw new UsernameNotFoundException("User does not exist");
        }
        return appUser;
    }
}
