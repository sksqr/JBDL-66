package com.gfg.controller;


import com.gfg.dto.UserDto;
import com.gfg.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public Long createUser(@RequestBody @Valid UserDto userDto) throws ExecutionException, InterruptedException {
        return userService.createUser(userDto);
    }
}
