package com.lobanova.electroniclibrary.controllers;

import com.lobanova.electroniclibrary.dtos.BookDto;
import com.lobanova.electroniclibrary.services.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookServiceImpl bookService;

    @Autowired
    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public Set<BookDto> getAllBooks() {
        return bookService.getAll();
    }

    @PostMapping
    public BookDto create(@RequestBody @NonNull BookDto newBook) {
        return bookService.create(newBook);
    }

    @GetMapping(path = "/{id}")
    public BookDto read(@PathVariable("id")@NonNull Long id) {
        return bookService.read(id);
    }

    @PutMapping
    public BookDto update(@RequestBody @NonNull BookDto updatedBook) {
        return bookService.update(updatedBook);
    }

    @PutMapping(path = "/delete/{id}")
    public void deleteBooks(@PathVariable("id") @NonNull Long id) {
        bookService.delete(id);
    }

    @DeleteMapping
    public void deleteAll() {
        bookService.deleteAll();
    }
}
