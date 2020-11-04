package com.lobanova.electroniclibrary.services;


import com.lobanova.electroniclibrary.dtos.UserDto;

public interface UserService extends Service<UserDto>{

    UserDto signUp(String login, String password);

    UserDto getUserById(Long id);
}
