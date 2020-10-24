package com.lobanova.electroniclibrary.repositories;

import com.lobanova.electroniclibrary.entities.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long>{

    List<Comment> findAllByAuthorComment_Id(Long id);
}
