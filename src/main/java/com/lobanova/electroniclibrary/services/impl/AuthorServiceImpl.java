package com.lobanova.electroniclibrary.services.impl;

import com.lobanova.electroniclibrary.dtos.AuthorDto;
import com.lobanova.electroniclibrary.entities.Author;
import com.lobanova.electroniclibrary.repositories.AuthorRepository;
import com.lobanova.electroniclibrary.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final ConversionService conversionService;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, ConversionService conversionService) {
        this.authorRepository = authorRepository;
        this.conversionService = conversionService;
    }

    @Override
    public AuthorDto create(AuthorDto dto) {
        Author author = conversionService.convert(dto, Author.class);
        author = authorRepository.save(author);
        return conversionService.convert(author, AuthorDto.class);
    }

    @Override
    public AuthorDto read(Long id) {
        Author author = authorRepository.findById(id).orElseThrow(RuntimeException::new);
        return conversionService.convert(author, AuthorDto.class);
    }

    @Override
    public AuthorDto update(AuthorDto dto) {
        Author author = conversionService.convert(dto, Author.class);
        author = authorRepository.save(author);
        return conversionService.convert(author, AuthorDto.class);
    }

    @Override
    public void delete(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public Set<AuthorDto> getAll() {
        Set<Author> authors = new HashSet<>((Collection<? extends Author>) authorRepository.findAll());
        return authors.stream().map(author -> conversionService.convert(author, AuthorDto.class)).collect(Collectors.toSet());
    }

    public void deleteAll() {
        authorRepository.deleteAll();
    }
}
