package com.lobanova.electroniclibrary.services;

import com.lobanova.electroniclibrary.dtos.CommentDto;
import com.lobanova.electroniclibrary.entities.Comment;

import java.util.List;

public interface CommentService extends Service<CommentDto>{

    List<Comment> getCommentsByUserId(Long userId);
}
