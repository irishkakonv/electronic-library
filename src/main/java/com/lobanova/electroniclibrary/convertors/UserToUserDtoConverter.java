package com.lobanova.electroniclibrary.convertors;

import com.lobanova.electroniclibrary.dtos.UserDto;
import com.lobanova.electroniclibrary.entities.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDtoConverter implements Converter<User, UserDto> {
    @Override
    public UserDto convert(User user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .country(user.getAddress() != null ? user.getAddress().getCountry() : null)
                .city(user.getAddress() != null ? user.getAddress().getCity() : null)
                .type(user.getType().getName())
                .login(user.getUserLogin())
                .build();
    }
}
