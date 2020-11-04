package com.lobanova.electroniclibrary.services.impl;

import com.lobanova.electroniclibrary.dtos.UserDto;
import com.lobanova.electroniclibrary.entities.CustomUserDetails;
import com.lobanova.electroniclibrary.entities.User;
import com.lobanova.electroniclibrary.repositories.UserAuthorityRepository;
import com.lobanova.electroniclibrary.repositories.UserDetailsRepository;
import com.lobanova.electroniclibrary.services.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.stream.StreamSupport;

@Service
public class CustomUserDetailServiceImpl implements CustomUserDetailService {

    private final UserDetailsRepository customUserDetailsRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserAuthorityRepository userAuthorityRepository;

    @Autowired
    public CustomUserDetailServiceImpl(UserDetailsRepository customUserDetailsRepository,
                                       PasswordEncoder passwordEncoder,
                                       UserAuthorityRepository userAuthorityRepository) {
        this.customUserDetailsRepository = customUserDetailsRepository;
        this.passwordEncoder = passwordEncoder;
        this.userAuthorityRepository = userAuthorityRepository;
    }

    @Override
    public CustomUserDetails createUserDetails(User user, UserDto userDto) {
        CustomUserDetails customUserDetails = new CustomUserDetails();
        customUserDetails.setPassword(passwordEncoder.encode(userDto.getPassword()));
        customUserDetails.setUsername(user.getUserName());
        customUserDetails.setUserAuthority(
                StreamSupport.stream(
                userAuthorityRepository.findAll().spliterator(), false)
                .filter(userAuthority -> userAuthority.getAuthority().equals(user.getType().getAuthorityRole()))
                .findFirst().get());
        return customUserDetailsRepository.save(customUserDetails);
    }
}
