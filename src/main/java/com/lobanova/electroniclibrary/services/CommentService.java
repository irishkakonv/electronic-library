package com.lobanova.electroniclibrary.services;
;
import com.lobanova.electroniclibrary.DataBase;
import com.lobanova.electroniclibrary.entities.Comment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    public List<Comment> getAllComments() {
        return DataBase.comments;
    }

    public Comment getCommentById(Integer id) {
        Optional<Comment> oldComment =  getAllComments().stream().filter(comment -> comment.getId().equals(id)).findFirst();
        return oldComment.orElse(null);
    }

    public boolean addComment(Comment comment) {
        return getAllComments().add(comment);
    }

    public boolean updateComment (Comment comment) {
        boolean isUpdated = false;
        Comment oldComment = getCommentById(comment.getId());
        List<Comment> comments = getAllComments();
        if (oldComment == null) {
            comments.add(comment);
            isUpdated = true;
        } else if (!oldComment.equals(comment)) {
            comments.remove(comments.indexOf(oldComment));
            comments.add(comment);
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
