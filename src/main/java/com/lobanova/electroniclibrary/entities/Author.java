package com.lobanova.electroniclibrary.entities;

import com.lobanova.electroniclibrary.enums.PersonType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Author extends Person {

    private String deathDate;
    private String shortBiography;

    @Builder
    public Author(int id, String name, String surname, PersonType type) {
        super(id, name, surname, type);
    }
}
