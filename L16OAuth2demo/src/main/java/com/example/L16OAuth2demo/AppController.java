package com.example.L16OAuth2demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AppController {

    private static Logger LOGGER = LoggerFactory.getLogger(AppController.class);

    @GetMapping("/hello")
    public String getHello(){
        LOGGER.info("Processing Hello API");
        return "Hello from :"+Thread.currentThread().getName();
    }

    @GetMapping("/user")
    public Map<String,Object> user(){
        LOGGER.info("Processing USER API");
        OAuth2User user = (OAuth2User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Map<String,Object> userData = new HashMap<>();
        userData.put("name",user.getAttributes().get("name"));
        userData.put("company",user.getAttributes().get("company"));
        return userData;
    }


    @GetMapping("/user-details")
    public Map<String,Object> userDetails(){
        LOGGER.info("Processing USER Details API");
        OAuth2User user = (OAuth2User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();;
        return user.getAttributes();
    }



}
