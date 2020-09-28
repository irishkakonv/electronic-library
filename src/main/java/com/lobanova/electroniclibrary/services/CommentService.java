package com.lobanova.electroniclibrary.services;
;
import com.lobanova.electroniclibrary.DataBase;
import com.lobanova.electroniclibrary.dtos.CommentDto;
import com.lobanova.electroniclibrary.entities.Comment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private Comment convertCommentDtoToComment(CommentDto comment) {
        return Comment.builder().id(comment.getId()).content(comment.getContent()).book(comment.getBook()).rate(comment.getRate()).build();
    }

    private CommentDto convertCommentToCommentDto(Comment comment) {
        return CommentDto.builder().id(comment.getId()).content(comment.getContent()).book(comment.getBook()).rate(comment.getRate()).build();
    }

    private List<Comment> getAllComments() {
        return DataBase.comments;
    }

    public List<CommentDto> getAllCommentDtos() {
        return getAllComments().stream().map(this::convertCommentToCommentDto).collect(Collectors.toList());
    }

    public CommentDto getCommentDtoById(Integer id) {
        Comment comment = getCommentById(id);
        return comment != null ? convertCommentToCommentDto(comment) : null;
    }

    private Comment getCommentById(Integer id) {
        Optional<Comment> oldComment =  getAllComments().stream().filter(comment -> comment.getId().equals(id)).findFirst();
        return oldComment.orElse(null);
    }

    public boolean addComment(CommentDto comment) {
        return getAllComments().add(convertCommentDtoToComment(comment));
    }

    public boolean updateComment (CommentDto commentDto) {
        boolean isUpdated = false;
        Comment oldComment = getCommentById(commentDto.getId());
        Comment newComment = convertCommentDtoToComment(commentDto);
        List<Comment> comments = getAllComments();
        if (oldComment == null) {
            comments.add(newComment);
            isUpdated = true;
        } else if (!oldComment.equals(newComment)) {
            comments.remove(comments.indexOf(oldComment));
            comments.add(newComment);
            isUpdated = true;
        }
        return isUpdated;
    }

    public void deleteComments(Integer id) {
        Comment commentForDelete = getCommentById(id);
        List<Comment> comments = getAllComments();
        if (commentForDelete != null) {
            comments.remove(comments.indexOf(commentForDelete));
        }
    }
}
