package com.lobanova.electroniclibrary.entities;

import com.lobanova.electroniclibrary.enums.PersonType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
abstract public class Person {

    private Integer id;
    private String name;
    private String surname;
    private String birthDay;
    private Address address;
    private PersonType type;

    public Person(int id, String name, String surname, PersonType type) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.type = type;
    }

    public Person(Integer id, String name, String surname, Address address, PersonType type) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.type = type;
        this.address = address;
    }
}
