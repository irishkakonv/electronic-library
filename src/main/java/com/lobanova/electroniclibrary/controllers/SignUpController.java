package com.lobanova.electroniclibrary.controllers;

import com.lobanova.electroniclibrary.dtos.UserDto;
import com.lobanova.electroniclibrary.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signUp")
public class SignUpController {

    private final UserService userService;

    @Autowired
    public SignUpController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserDto signUp(String login, String password) {
       return userService.signUp(login, password);
    }
}
