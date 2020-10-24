package com.lobanova.electroniclibrary.convertors;

import com.lobanova.electroniclibrary.dtos.AuthorDto;
import com.lobanova.electroniclibrary.entities.Author;
import com.lobanova.electroniclibrary.entities.Book;
import com.lobanova.electroniclibrary.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Component
public class AuthorDtoToAuthorConverter implements Converter<AuthorDto, Author>{

    private final BookRepository bookRepository;

    @Autowired
    public AuthorDtoToAuthorConverter(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Author convert(AuthorDto authorDto) {
        Author author = new Author();
        author.setId(authorDto.getId());
        author.setName(authorDto.getName());
        author.setSurname(authorDto.getSurname());
        author.setShortBiography(authorDto.getShortBiography());
        author.setBooks(new HashSet<>((Collection<? extends Book>) bookRepository.findAllById(authorDto.getBooks())));
        return author;
    }
}
