package com.lobanova.electroniclibrary.convertors;

import com.lobanova.electroniclibrary.dtos.UserDto;
import com.lobanova.electroniclibrary.entities.User;
import com.lobanova.electroniclibrary.enums.UserType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToUserConverter implements Converter<UserDto, User> {

    @Override
    public User convert(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setType(UserType.getUserType(userDto.getType()));
        user.setUserLogin(userDto.getLogin());
        user.setPassword(userDto.getPassword());
        return user;
    }
}
