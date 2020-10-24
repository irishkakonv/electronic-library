package com.lobanova.electroniclibrary.controllers;

import com.lobanova.electroniclibrary.dtos.AuthorDto;
import com.lobanova.electroniclibrary.services.impl.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("authors")
public class AuthorController {

    private final AuthorServiceImpl authorService;

    @Autowired
    public AuthorController(AuthorServiceImpl authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public Set<AuthorDto> getAllAuthors() {
        return authorService.getAll();
    }


    @PostMapping
    public AuthorDto create(@RequestBody AuthorDto newAuthor) {
        return authorService.create(newAuthor);
    }

    @GetMapping(path = "{id}")
    public AuthorDto read(@PathVariable("id") Long id) {
        return authorService.read(id);
    }

    @PutMapping
    public AuthorDto update(@RequestBody AuthorDto updatedAuthor) {
        return authorService.update(updatedAuthor);
    }

    @PutMapping(path = "/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        authorService.delete(id);
    }

    @DeleteMapping
    public void deleteAll(){
        authorService.deleteAll();
    }
}
