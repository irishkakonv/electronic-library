package com.lobanova.electroniclibrary.controllers;

import com.lobanova.electroniclibrary.dtos.UserDto;
import com.lobanova.electroniclibrary.entities.Author;
import com.lobanova.electroniclibrary.entities.User;
import com.lobanova.electroniclibrary.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path ="/get-all")
    public List<UserDto> getAllUsers() {
        return userService.getAllUserDtos();
    }

    @GetMapping(path = "{id}")
    public UserDto getUserById(@PathVariable("id") Integer id) {
        return userService.getUserDtoById(id);
    }

    @PostMapping
    public UserDto addUser(@RequestBody UserDto newUser) {
        return newUser != null && userService.addUser(newUser) ? newUser : null;
    }

    @PutMapping
    public UserDto updateUser(@RequestBody UserDto updatedUser) {
        return userService.updateUser(updatedUser) ? updatedUser : null;
    }

    @PutMapping(path = "/delete/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
    }
}
