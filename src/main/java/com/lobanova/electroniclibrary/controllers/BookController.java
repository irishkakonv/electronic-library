package com.lobanova.electroniclibrary.controllers;

import com.lobanova.electroniclibrary.DataBase;
import com.lobanova.electroniclibrary.entities.Book;
import com.lobanova.electroniclibrary.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(path ="/get-all")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping(path = "{id}")
    public Book getBookById(@PathVariable("id") Integer id) {
        return bookService.getBookById(id);
    }

    @PostMapping
    public Book addBook(@RequestBody Book newBook) {
        return newBook != null && bookService.addBook(newBook) ? newBook : null;
    }

    @PutMapping
    public Book updateBook(@RequestBody Book updatedBook) {
        return bookService.updateBook(updatedBook) ? updatedBook : null;
    }

    @PutMapping(path = "/delete/{id}")
    public void deleteBooks(@PathVariable("id") Integer id) {
        bookService.deleteBooks(id);
    }
}
