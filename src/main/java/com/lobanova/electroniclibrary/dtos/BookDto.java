package com.lobanova.electroniclibrary.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    private Long id;
    private String name;
    private Set<AuthorDto> authors;
    private String genre;
    private String description;
    private int pageCount;
    private int commonRate;

}
