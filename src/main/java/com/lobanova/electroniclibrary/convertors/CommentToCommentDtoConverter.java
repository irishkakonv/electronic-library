package com.lobanova.electroniclibrary.convertors;

import com.lobanova.electroniclibrary.dtos.CommentDto;
import com.lobanova.electroniclibrary.entities.Comment;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CommentToCommentDtoConverter implements Converter<Comment, CommentDto>{
    @Override
    public CommentDto convert(Comment comment) {
        return CommentDto.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .bookId(comment.getBook().getId())
                .authorId(comment.getAuthorComment().getId())
                .rate(comment.getRate())
                .build();
    }
}
