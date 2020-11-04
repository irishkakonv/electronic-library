package com.lobanova.electroniclibrary.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto {

    private Long id;
    private String name;
    private String surname;
    private String shortBiography;
    private Set<BookDto> books;
}
