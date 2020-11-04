package com.lobanova.electroniclibrary.convertors;

import com.lobanova.electroniclibrary.dtos.UserDto;
import com.lobanova.electroniclibrary.entities.Address;
import com.lobanova.electroniclibrary.entities.User;
import com.lobanova.electroniclibrary.enums.UserRole;
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
        user.setType(UserRole.getUserType(userDto.getType()));
        user.setUserName(userDto.getLogin());
        Address address = new Address(userDto.getCountry(), userDto.getCity());
        user.addAddress(address);
        return user;
    }
}
