package com.lobanova.electroniclibrary.dtos;

import com.lobanova.electroniclibrary.enums.PersonType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AuthorDto {

    private Integer id;
    private String name;
    private String surname;
    private String birthDay;
    private PersonType type;
    private String deathDate;
    private String shortBiography;

}
