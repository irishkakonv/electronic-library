package com.lobanova.electroniclibrary.convertors;

import com.lobanova.electroniclibrary.dtos.AuthorDto;
import com.lobanova.electroniclibrary.entities.Author;
import com.lobanova.electroniclibrary.entities.Book;
import com.lobanova.electroniclibrary.enums.Genre;
import com.lobanova.electroniclibrary.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AuthorDtoToAuthorConverter implements Converter<AuthorDto, Author>{

    @Override
    public Author convert(AuthorDto authorDto) {
        Author author = new Author();
        author.setId(authorDto.getId());
        author.setName(authorDto.getName());
        author.setSurname(authorDto.getSurname());
        author.setShortBiography(authorDto.getShortBiography());
        if (authorDto.getBooks() !=null) {
            authorDto.getBooks().forEach(bookDto -> {
                Book book = new Book();
                book.setId(bookDto.getId());
                book.setName(bookDto.getName());
                book.setPageCount(bookDto.getPageCount());
                book.setGenre(Genre.getGenre(bookDto.getGenre()));
                book.setDescription(bookDto.getDescription());
                book.addAuthor(author);
                author.addBook(book);
            });
        }
        return author;
    }
}
