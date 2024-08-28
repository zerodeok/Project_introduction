package com.sparta.todo.service;


import com.sparta.todo.dto.comment.CommentSaveRequestDto;
import com.sparta.todo.dto.comment.CommentSaveResponceDto;
import com.sparta.todo.entity.Comment;
import com.sparta.todo.entity.Todo;
import com.sparta.todo.repository.CommentRepository;
import com.sparta.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class CommentService {

    private final CommentRepository commentRepository;
    private final TodoRepository todoRepository;

    public CommentSaveResponceDto saveComment(Long todoId, CommentSaveRequestDto commentSaveRequestDto) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new NullPointerException("일정이 존재하지 않습니다."));

        Comment newComment = new Comment(commentSaveRequestDto.getComment(), commentSaveRequestDto.getUserName(), todo);
        Comment savedComment = commentRepository.save(newComment);

        return new CommentSaveResponceDto(savedComment.getCommentId(), savedComment.getComment(), savedComment.getUserName());
    }
}
