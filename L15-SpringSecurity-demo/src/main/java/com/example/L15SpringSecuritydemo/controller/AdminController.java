package com.example.L15SpringSecuritydemo.controller;

import com.example.L15SpringSecuritydemo.entity.AppUser;
import com.example.L15SpringSecuritydemo.service.AppUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private static Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AppUserService appUserService;


    @GetMapping
    public String getHelloApp(){
        LOGGER.info("Processing hello req ");
        return "Hello App!! from Admin "+Thread.currentThread().getName();
    }

    @PostMapping("/createUser")
    public Long createUser(@RequestBody AppUser appUser){
        Long id = appUserService.createUser(appUser);
        return id;
    }

    @GetMapping("/changePassword")
    public ResponseEntity<String> changePassword(@AuthenticationPrincipal AppUser appUser, @RequestParam String newPassword){
        appUserService.changePassword(appUser,newPassword);
        return ResponseEntity.ok("Password changed");

    }

}
