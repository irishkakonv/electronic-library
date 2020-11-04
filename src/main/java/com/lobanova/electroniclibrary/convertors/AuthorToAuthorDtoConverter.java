package com.lobanova.electroniclibrary.convertors;

import com.lobanova.electroniclibrary.dtos.AuthorDto;
import com.lobanova.electroniclibrary.dtos.BookDto;
import com.lobanova.electroniclibrary.entities.Author;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class AuthorToAuthorDtoConverter implements Converter<Author, AuthorDto> {

    @Override
    public AuthorDto convert(Author author) {
        return AuthorDto.builder()
                .id(author.getId())
                .name(author.getName())
                .surname(author.getSurname())
                .shortBiography(author.getShortBiography())
                .build();
    }
}
