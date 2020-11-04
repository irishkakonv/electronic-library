package com.lobanova.electroniclibrary.convertors;

import com.lobanova.electroniclibrary.dtos.BookDto;
import com.lobanova.electroniclibrary.entities.Author;
import com.lobanova.electroniclibrary.entities.Book;
import com.lobanova.electroniclibrary.enums.Genre;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BookDtoToBookConvert implements Converter<BookDto, Book>{

    @Override
    public Book convert(BookDto bookDto) {
        Book book = new Book();
        book.setId(bookDto.getId());
        book.setName(bookDto.getName());
        book.setDescription(bookDto.getDescription());
        book.setGenre(Genre.getGenre(bookDto.getGenre()));
        book.setPageCount(bookDto.getPageCount());
        if (bookDto.getAuthors() != null) {
            bookDto.getAuthors().forEach(authorDto -> {
                Author author = new Author();
                author.setId(bookDto.getId());
                author.setName(authorDto.getName());
                author.setSurname(authorDto.getSurname());
                author.addBook(book);
                book.addAuthor(author);
            });
        }
        return book;
    }
}
