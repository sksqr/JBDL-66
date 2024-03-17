package com.example.L10minorproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("12345"));
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
                .authorizeHttpRequests((auth)->{
                    auth.requestMatchers("/admin/**").hasAnyAuthority("ADMIN")
                            .requestMatchers("/gatekeeper/**").hasAnyAuthority("GATEKEEPER")
                            .requestMatchers("/resident/**").hasAnyAuthority("RESIDENT")
                            .requestMatchers("/public/**")
                            .permitAll()
                            .anyRequest()
                            .authenticated();
                })
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return httpSecurity.build();
    }

}
