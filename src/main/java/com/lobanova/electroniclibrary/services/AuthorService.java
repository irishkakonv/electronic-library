package com.lobanova.electroniclibrary.services;

import com.lobanova.electroniclibrary.DataBase;
import com.lobanova.electroniclibrary.entities.Author;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    public List<Author> getAllAuthors() {
        return DataBase.authors;
    }

    public Author getAuthorById(Integer id) {
        Optional<Author> oldBook =  getAllAuthors().stream().filter(author -> author.getId().equals(id)).findFirst();
        return oldBook.orElse(null);
    }

    public boolean addAuthor(Author newAuthor) {
        return getAllAuthors().add(newAuthor);
    }

    public boolean updateAuthor(Author newAuthor) {
        boolean isUpdated = false;
        Author oldAuthor = getAuthorById(newAuthor.getId());
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
