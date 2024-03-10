package com.example.L14SpringSecuritydemo.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping
    public String getHelloApp(){
        return "Hello App!! from Admin "+Thread.currentThread().getName();
    }
}
