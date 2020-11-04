package com.lobanova.electroniclibrary.services;

import com.lobanova.electroniclibrary.dtos.UserDto;
import com.lobanova.electroniclibrary.entities.CustomUserDetails;
import com.lobanova.electroniclibrary.entities.User;

public interface CustomUserDetailService {

    CustomUserDetails createUserDetails(User user, UserDto userDto);
}
