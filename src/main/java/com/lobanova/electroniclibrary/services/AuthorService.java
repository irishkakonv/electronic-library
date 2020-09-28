package com.lobanova.electroniclibrary.services;

import com.lobanova.electroniclibrary.DataBase;
import com.lobanova.electroniclibrary.dtos.AuthorDto;
import com.lobanova.electroniclibrary.entities.Author;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private AuthorDto convertAuthorToAuthorDto(Author author) {
        return AuthorDto.builder().id(author.getId()).name(author.getName()).surname(author.getSurname()).type(author.getType()).build();
    }

    private Author convertAuthorDtoToAuthor(AuthorDto authorDto) {
        return Author.builder().id(authorDto.getId()).name(authorDto.getName()).surname(authorDto.getSurname()).type(authorDto.getType()).build();
    }

    private List<Author> getAllAuthors() {
        return DataBase.authors;
    }

    public List<AuthorDto> getAllAuthorDtos() {
        return getAllAuthors().stream().map(this::convertAuthorToAuthorDto).collect(Collectors.toList());
    }

    public AuthorDto getAuthorDtoById(Integer id) {
        Author author = getAuthorById(id);
        return author != null ? convertAuthorToAuthorDto(author) : null;
    }

    private Author getAuthorById(Integer id) {
        Optional<Author> oldBook =  getAllAuthors().stream().filter(author -> author.getId().equals(id)).findFirst();
        return oldBook.orElse(null);
    }

    public boolean addAuthor(AuthorDto newAuthor) {
        return getAllAuthors().add(convertAuthorDtoToAuthor(newAuthor));
    }

    public boolean updateAuthor(AuthorDto newAuthorDto) {
        boolean isUpdated = false;
        Author oldAuthor = getAuthorById(newAuthorDto.getId());
        Author newAuthor = convertAuthorDtoToAuthor(newAuthorDto);
        List<Author> authors = getAllAuthors();
        if (oldAuthor == null) {
            authors.add(newAuthor);
            isUpdated = true;
        } else if (!oldAuthor.equals(newAuthor)) {
            authors.remove(authors.indexOf(oldAuthor));
            authors.add(newAuthor);
            isUpdated = true;
        }
        return isUpdated;
    }

    public void deleteAuthor(Integer id) {
        Author authorForDelete = getAuthorById(id);
        List<Author> authors = getAllAuthors();
        if (authorForDelete != null) {
            authors.remove(authors.indexOf(authorForDelete));
        }
    }
}
