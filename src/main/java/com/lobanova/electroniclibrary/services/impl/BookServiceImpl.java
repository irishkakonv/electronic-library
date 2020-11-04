package com.lobanova.electroniclibrary.services.impl;

import com.lobanova.electroniclibrary.dtos.BookDto;
import com.lobanova.electroniclibrary.entities.Book;
import com.lobanova.electroniclibrary.repositories.BookRepository;
import com.lobanova.electroniclibrary.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final ConversionService conversionService;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository,
                           ConversionService conversionService) {
        this.bookRepository = bookRepository;
        this.conversionService = conversionService;
    }

    @Override
    public BookDto create(BookDto dto) {
        Book book = conversionService.convert(dto, Book.class);
        book = bookRepository.save(book);
        return conversionService.convert(book, BookDto.class);
    }

    @Override
    public BookDto read(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(RuntimeException::new);
        return conversionService.convert(book, BookDto.class);
    }

    @Override
    public BookDto update(BookDto dto) {
        Book book = conversionService.convert(dto, Book.class);
        book = bookRepository.save(book);
        return conversionService.convert(book, BookDto.class);
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Set<BookDto> getAll() {
        return StreamSupport.stream(bookRepository.findAll().spliterator(), false)
                .map(book -> conversionService.convert(book, BookDto.class))
                .collect(Collectors.toSet());
    }

    public void deleteAll() {
        bookRepository.deleteAll();
    }
}
