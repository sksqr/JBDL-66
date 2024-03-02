package com.example.L10minorproject.controller;

import com.example.L10minorproject.dto.UserDto;
import com.example.L10minorproject.entity.User;
import com.example.L10minorproject.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/createUser")
    ResponseEntity<Long> createUser(@RequestBody UserDto userDto){
        return ResponseEntity.ok(adminService.createUser(userDto));
    }

}
