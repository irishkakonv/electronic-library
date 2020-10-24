package com.lobanova.electroniclibrary.convertors;

import com.lobanova.electroniclibrary.dtos.CommentDto;
import com.lobanova.electroniclibrary.entities.Comment;
import com.lobanova.electroniclibrary.repositories.BookRepository;
import com.lobanova.electroniclibrary.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CommentDtoToCommentConverter implements Converter<CommentDto, Comment>{

    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    @Autowired
    public CommentDtoToCommentConverter(BookRepository bookRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Comment convert(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setRate(commentDto.getRate());
        comment.setBook(bookRepository.findById(commentDto.getBookId()).get());
        comment.setAuthorComment(userRepository.findById(commentDto.getAuthorId()).get());
        comment.setContent(commentDto.getContent());
        return comment;
    }
}
