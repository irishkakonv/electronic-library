package com.lobanova.electroniclibrary.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
}
