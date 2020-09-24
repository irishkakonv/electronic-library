package com.lobanova.electroniclibrary.entities;

import com.lobanova.electroniclibrary.enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {

    private int id;
    private String name;
    private List<Author> authors;
    private Genre genre;
    private String description;
    private String pageCount;
    private int commonRate;
    private byte[] content;
    private byte[] image;

}
