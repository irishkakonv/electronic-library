package com.lobanova.electroniclibrary.convertors;

import com.lobanova.electroniclibrary.dtos.BookDto;
import com.lobanova.electroniclibrary.entities.Book;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BookToBookDtoConverter implements Converter<Book, BookDto>{

    @Override
    public BookDto convert(Book book) {
        return BookDto.builder()
                .id(book.getId())
                .name(book.getName())
                .pageCount(book.getPageCount())
                .genre(book.getGenre().getName())
                .build();
    }
}
