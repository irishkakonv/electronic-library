package com.lobanova.electroniclibrary.services.impl;

import com.lobanova.electroniclibrary.entities.UserAuthority;
import com.lobanova.electroniclibrary.enums.UserRole;
import com.lobanova.electroniclibrary.repositories.UserAuthorityRepository;
import com.lobanova.electroniclibrary.services.UserAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserAuthorityImpl implements UserAuthorityService {

    private final UserAuthorityRepository userAuthorityRepository;

    @Autowired
    public UserAuthorityImpl(UserAuthorityRepository userAuthorityRepository) {
        this.userAuthorityRepository = userAuthorityRepository;
    }

    @Override
    public void createAuthorities(List<String> roles) {
        List<UserAuthority> authorities = new ArrayList<>();

        roles.forEach(role -> {
            authorities.add(new UserAuthority(UserRole.getUserAuthorityRole(role)));
        });
        userAuthorityRepository.saveAll(authorities);
    }

    @Override
    public List<String> getAuthorities() {
        return StreamSupport.stream(userAuthorityRepository.findAll().spliterator(), false)
                .map(UserAuthority::getAuthority)
                .collect(Collectors.toList());
    }
}
