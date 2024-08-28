package com.sparta.todo.controller;

import com.sparta.todo.dto.comment.CommentSaveRequestDto;
import com.sparta.todo.dto.comment.CommentSaveResponceDto;
import com.sparta.todo.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CommentController {

    private CommentService commentService;

    @PostMapping("/todos/{todoId}/comments")
    public CommentSaveResponceDto saveComment(
            @PathVariable Long todoId,
            @RequestBody CommentSaveRequestDto commentSaveRequestDto){
        return commentService.saveComment(todoId,commentSaveRequestDto);
    }
}
