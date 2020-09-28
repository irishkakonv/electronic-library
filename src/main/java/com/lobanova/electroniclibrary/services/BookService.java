package com.lobanova.electroniclibrary.services;

import com.lobanova.electroniclibrary.DataBase;
import com.lobanova.electroniclibrary.dtos.BookDto;
import com.lobanova.electroniclibrary.entities.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    private BookDto convertBookToBookDto(Book book) {
        return BookDto.builder().id(book.getId()).name(book.getName()).pageCount(book.getPageCount()).authors(book.getAuthors()).genre(book.getGenre()).build();
    }

    private Book convertBookDtoToBook(BookDto book) {
        return Book.builder().id(book.getId()).name(book.getName()).pageCount(book.getPageCount()).authors(book.getAuthors()).genre(book.getGenre()).build();
    }

    public List<Book> getAllBooks() {
        return DataBase.books;
    }

    public List<BookDto> getAllBookDtos() {
        return getAllBooks().stream().map(this::convertBookToBookDto).collect(Collectors.toList());
    }

    private Book getBookById(Integer id) {
        Optional<Book> oldBook =  getAllBooks().stream().filter(book -> book.getId().equals(id)).findFirst();
        return oldBook.orElse(null);
    }

    public BookDto getBookDtoById(Integer id) {
        Book book = getBookById(id);
        return book != null ? convertBookToBookDto(book) : null;
    }

    public boolean addBook(BookDto book) {
        return getAllBooks().add(convertBookDtoToBook(book));
    }

    public boolean updateBook (BookDto bookDto) {
        boolean isUpdated = false;
        Book oldBook = getBookById(bookDto.getId());
        Book newBook = convertBookDtoToBook(bookDto);
        List<Book> books = getAllBooks();
        if (oldBook == null) {
            books.add(newBook);
            isUpdated = true;
        } else if (!oldBook.equals(newBook)) {
            books.remove(books.indexOf(oldBook));
            books.add(newBook);
            isUpdated = true;
        }
        return isUpdated;
    }

    public void deleteBooks(Integer id) {
        Book bookForDelete = getBookById(id);
        List<Book> books = getAllBooks();
        if (bookForDelete != null) {
            books.remove(books.indexOf(bookForDelete));
        }
    }
}
