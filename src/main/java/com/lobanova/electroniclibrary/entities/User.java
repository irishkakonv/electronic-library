package com.lobanova.electroniclibrary.entities;

import com.lobanova.electroniclibrary.enums.PersonType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User extends Person {

    private String userLogin;
    private String password;
    List<Comment> comments;

    @Builder
    public User(Integer id, @NonNull String name, @NonNull String surname, Address address, @NonNull PersonType type, List<Comment> comments) {
        super(id, name, surname, address, type);
        this.comments = comments;
    }
}
