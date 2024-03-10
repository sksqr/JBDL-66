package com.example.L14SpringSecuritydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails userDetails1 = User.builder()
//                .username("rahul")
//                .password("$2a$10$V7Y6Umm0APInw0jUPICMQubGU5Mqc6Whie42m9QnIewuVltidhtsG")
//                .build();
//
//        UserDetails userDetails2 = User.builder()
//                .username("ravi")
//                .password("$2a$10$AsJijLqcGhWkEjgalvdFIOwr1ubbWkISLG7yeDBZPamvxKgr9E4cm")
//                .build();
//
//        return new InMemoryUserDetailsManager(userDetails1,userDetails2);
//    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests((auth)->{
                    auth.requestMatchers("/admin/**").hasAnyAuthority("ADMIN")
                            .requestMatchers("/public/**")
                            .permitAll()
                            .anyRequest()
                            .authenticated();
                })
                .formLogin(Customizer.withDefaults());
        return httpSecurity.build();
    }

}
