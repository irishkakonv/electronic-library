package com.lobanova.electroniclibrary.services;

import com.lobanova.electroniclibrary.DataBase;
import com.lobanova.electroniclibrary.entities.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    public List<Book> getAllBooks() {
        return DataBase.books;
    }

    public Book getBookById(Integer id) {
        Optional<Book> oldBook =  getAllBooks().stream().filter(book -> book.getId().equals(id)).findFirst();
        return oldBook.orElse(null);
    }

    public boolean addBook(Book book) {
        return getAllBooks().add(book);
    }

    public boolean updateBook (Book book) {
        boolean isUpdated = false;
        Book oldBook = getBookById(book.getId());
        List<Book> books = getAllBooks();
        if (oldBook == null) {
            books.add(book);
            isUpdated = true;
        } else if (!oldBook.equals(book)) {
            books.remove(books.indexOf(oldBook));
            books.add(book);
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
