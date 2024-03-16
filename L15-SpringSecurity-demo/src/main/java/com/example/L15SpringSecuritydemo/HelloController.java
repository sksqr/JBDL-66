package com.example.L15SpringSecuritydemo;


import com.example.L15SpringSecuritydemo.controller.AdminController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    private static Logger LOGGER = LoggerFactory.getLogger(AdminController.class);
    @GetMapping
    public String getHello(@AuthenticationPrincipal UserDetails userDetails){
        LOGGER.info("Processing hello req ");
       // UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "Hello "+ userDetails.getUsername()+"!! from "+Thread.currentThread().getName();
    }
}
