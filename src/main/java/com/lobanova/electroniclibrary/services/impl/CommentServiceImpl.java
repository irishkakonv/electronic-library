package com.lobanova.electroniclibrary.services.impl;

import com.lobanova.electroniclibrary.dtos.CommentDto;
import com.lobanova.electroniclibrary.entities.Comment;
import com.lobanova.electroniclibrary.repositories.CommentRepository;
import com.lobanova.electroniclibrary.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class CommentServiceImpl implements CommentService{

    private final ConversionService conversionService;
    private final CommentRepository commentRepository;

    @Autowired

    public CommentServiceImpl(ConversionService conversionService,
                              CommentRepository commentRepository) {
        this.conversionService = conversionService;
        this.commentRepository = commentRepository;
    }

    @Override
    public CommentDto create(CommentDto dto) {
        Comment comment = conversionService.convert(dto, Comment.class);
        comment = commentRepository.save(comment);
        return conversionService.convert(comment, CommentDto.class);
    }

    @Override
    public CommentDto read(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(RuntimeException::new);
        return conversionService.convert(comment, CommentDto.class);
    }

    @Override
    public CommentDto update(CommentDto dto) {
        Comment comment = conversionService.convert(dto, Comment.class);
        comment = commentRepository.save(comment);
        return conversionService.convert(comment, CommentDto.class);
    }

    @Override
    public void delete(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public Set<CommentDto> getAll() {
        return StreamSupport.stream(commentRepository.findAll().spliterator(), false)
                .map(comment -> conversionService.convert(comment, CommentDto.class))
                .collect(Collectors.toSet());
    }

    @Override
    public List<Comment> getCommentsByUserId(Long userId) {
        return commentRepository.findAllByAuthorComment_Id(userId);
    }
}
