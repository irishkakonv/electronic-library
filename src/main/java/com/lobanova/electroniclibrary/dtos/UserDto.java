package com.lobanova.electroniclibrary.dtos;

import com.lobanova.electroniclibrary.entities.Address;
import com.lobanova.electroniclibrary.entities.Comment;
import com.lobanova.electroniclibrary.entities.Person;
import com.lobanova.electroniclibrary.enums.PersonType;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class UserDto {

    private Integer id;
    private String name;
    private String surname;
    private String birthDay;
    private Address address;
    private PersonType type;
    private String userLogin;
    private String password;
    List<Comment> comments;
}
