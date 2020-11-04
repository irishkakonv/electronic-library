package com.lobanova.electroniclibrary.services;


import java.util.List;

public interface UserAuthorityService {

    void createAuthorities(List<String> roles);

    List<String> getAuthorities();
}
