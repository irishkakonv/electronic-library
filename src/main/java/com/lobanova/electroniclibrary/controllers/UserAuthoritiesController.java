package com.lobanova.electroniclibrary.controllers;

import com.lobanova.electroniclibrary.services.UserAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/authorities")
public class UserAuthoritiesController {

    private final UserAuthorityService userAuthorityService;

    @Autowired
    public UserAuthoritiesController(UserAuthorityService userAuthorityService) {
        this.userAuthorityService = userAuthorityService;
    }

    @PostMapping
    public void createAuthorities(@RequestBody List<String> roles) {
        userAuthorityService.createAuthorities(roles);
    }

    @GetMapping
    public List<String> getAuthorities() {
        return userAuthorityService.getAuthorities();
    }
}
