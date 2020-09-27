package com.lobanova.electroniclibrary.controllers;

import com.lobanova.electroniclibrary.entities.Comment;
import com.lobanova.electroniclibrary.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("comments")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping(path ="/get-all")
    public List<Comment> getAllComments() {
        return commentService.getAllComments();
    }

    @GetMapping(path = "{id}")
    public Comment getCommentById(@PathVariable("id") Integer id) {
        return commentService.getCommentById(id);
    }

    @PostMapping
    public Comment addComment(@RequestBody Comment newComment) {
        return newComment != null && commentService.addComment(newComment) ? newComment : null;
    }

    @PutMapping
    public Comment updateComment(@RequestBody Comment updatedComment) {
        return commentService.updateComment(updatedComment) ? updatedComment : null;
    }

    @PutMapping(path = "/delete/{id}")
    public void deleteComments(@PathVariable("id") Integer id) {
        commentService.deleteComments(id);
    }
}
