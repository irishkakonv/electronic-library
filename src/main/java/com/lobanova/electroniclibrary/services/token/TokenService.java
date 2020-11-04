package com.lobanova.electroniclibrary.services.token;

import org.springframework.security.core.userdetails.UserDetails;

public interface TokenService {

    String generateToken(UserDetails userDetails);
    String getUsernameFromToken(String token);
}
