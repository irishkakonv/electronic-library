package com.lobanova.electroniclibrary.repositories;

import com.lobanova.electroniclibrary.entities.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long>{
}
