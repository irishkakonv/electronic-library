package com.lobanova.electroniclibrary.dtos;

import com.lobanova.electroniclibrary.entities.Author;
import com.lobanova.electroniclibrary.enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Builder
public class BookDto {

    private Integer id;
    private String name;
    private List<Author> authors;
    private Genre genre;
    private String description;
    private int pageCount;
    private int commonRate;
    private byte[] content;
    private byte[] image;

}
