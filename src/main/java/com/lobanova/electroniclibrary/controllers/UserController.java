package com.lobanova.electroniclibrary.controllers;

import com.lobanova.electroniclibrary.dtos.UserDto;
import com.lobanova.electroniclibrary.services.UserService;
import com.lobanova.electroniclibrary.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    public Set<UserDto> getAllUsers() {
        return userService.getAll();
    }

    @PostMapping
    public UserDto create(@RequestBody @NonNull UserDto newUser) {
        return userService.create(newUser);
    }

    @GetMapping(path = "/{id}")
    public UserDto read(@PathVariable("id") @NonNull Long id) {
        return userService.read(id);
    }

    @PutMapping
    public UserDto update(@RequestBody @NonNull UserDto updatedUser) {
        return userService.update(updatedUser);
    }

    @PutMapping(path = "/delete/{id}")
    public void deleteUser(@PathVariable("id") @NonNull Long id) {
        userService.delete(id);
    }
}
