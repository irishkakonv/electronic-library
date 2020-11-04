package com.lobanova.electroniclibrary.controllers;

import com.lobanova.electroniclibrary.dtos.TokenDto;
import com.lobanova.electroniclibrary.dtos.TokenRequest;
import com.lobanova.electroniclibrary.services.token.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authenticate")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final TokenService tokenService;

    @PostMapping
    public TokenDto getToken(@RequestBody TokenRequest tokenRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(tokenRequest.getUsername(), tokenRequest.getPassword()));
        UserDetails userDetails = userDetailsService.loadUserByUsername(tokenRequest.getUsername());
        String token = tokenService.generateToken(userDetails);
        return TokenDto.builder().token(token).build();
    }
}
