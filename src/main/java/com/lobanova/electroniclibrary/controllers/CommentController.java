package com.lobanova.electroniclibrary.controllers;

import com.lobanova.electroniclibrary.dtos.CommentDto;
import com.lobanova.electroniclibrary.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public Set<CommentDto> getAllComments() {
        return commentService.getAll();
    }

    @PostMapping
    public CommentDto create(@RequestBody @NonNull CommentDto newComment) {
        return commentService.create(newComment);
    }

    @GetMapping(path = "/{id}")
    public CommentDto read(@PathVariable("id") @NonNull Long id) {
        return commentService.read(id);
    }

    @PutMapping
    public CommentDto update(@RequestBody @NonNull CommentDto updatedComment) {
        return commentService.update(updatedComment);
    }

    @PutMapping(path = "/delete/{id}")
    public void deleteComments(@PathVariable("id") @NonNull Long id) {
        commentService.delete(id);
    }
}
