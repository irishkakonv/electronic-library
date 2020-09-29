package com.lobanova.electroniclibrary.controllers;

import com.lobanova.electroniclibrary.dtos.AuthorDto;
import com.lobanova.electroniclibrary.entities.Author;
import com.lobanova.electroniclibrary.entities.Book;
import com.lobanova.electroniclibrary.services.AuthorService;
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
@RequestMapping("authors")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<AuthorDto> getAllAuthors() {
        return authorService.getAllAuthorDtos();
    }

    @GetMapping(path = "{id}")
    public AuthorDto getAuthorDtoById(@PathVariable("id") Integer id) {
        return authorService.getAuthorDtoById(id);
    }

    @PostMapping
    public AuthorDto addAuthor(@RequestBody AuthorDto newAuthor) {
        return newAuthor != null && authorService.addAuthor(newAuthor) ? newAuthor : null;
    }

    @PutMapping
    public AuthorDto updateBook(@RequestBody AuthorDto updatedAuthor) {
        return authorService.updateAuthor(updatedAuthor) ? updatedAuthor : null;
    }

    @PutMapping(path = "/delete/{id}")
    public void deleteAuthor(@PathVariable("id") Integer id) {
        authorService.deleteAuthor(id);
    }
}
