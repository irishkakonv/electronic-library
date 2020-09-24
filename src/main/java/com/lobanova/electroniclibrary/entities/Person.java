package com.lobanova.electroniclibrary.entities;

import com.lobanova.electroniclibrary.enums.PersonType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
abstract public class Person {

    private int id;
    private String name;
    private String surname;
    private String birthDay;
    private Address address;
    private PersonType type;

}
