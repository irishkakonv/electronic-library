package com.lobanova.electroniclibrary.convertors;

import com.lobanova.electroniclibrary.dtos.BookDto;
import com.lobanova.electroniclibrary.entities.Author;
import com.lobanova.electroniclibrary.entities.Book;
import com.lobanova.electroniclibrary.enums.Genre;
import com.lobanova.electroniclibrary.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;

@Component
public class BookDtoToBookConvert implements Converter<BookDto, Book>{

    private final AuthorRepository authorRepository;

    @Autowired
    public BookDtoToBookConvert(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public Book convert(BookDto bookDto) {
        Book book = new Book();
        book.setId(bookDto.getId());
        book.setName(bookDto.getName());
        book.setAuthors(new HashSet<>((Collection<? extends Author>) authorRepository.findAllById(bookDto.getAuthors())));
//        book.setContent(bookDto.getContent());
        book.setDescription(bookDto.getDescription());
        book.setGenre(Genre.getGenre(bookDto.getGenre()));
//        book.setImage(bookDto.getImage());
        book.setPageCount(bookDto.getPageCount());
        return book;
    }
}
