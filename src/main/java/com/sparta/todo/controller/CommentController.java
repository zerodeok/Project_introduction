package com.sparta.todo.controller;

import com.sparta.todo.dto.comment.CommentDetailResponseDto;
import com.sparta.todo.dto.comment.CommentSaveRequestDto;
import com.sparta.todo.dto.comment.CommentSaveResponceDto;
import com.sparta.todo.dto.comment.CommnetSimpleResponseDto;
import com.sparta.todo.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/todos/{todoId}/comments")
    public ResponseEntity<CommentSaveResponceDto> saveComment(
            @PathVariable Long todoId,
            @RequestBody CommentSaveRequestDto commentSaveRequestDto){
        return ResponseEntity.ok(commentService.saveComment(todoId,commentSaveRequestDto));
    }

    //댓글 다건조회
    @GetMapping("/todos/{todoId}/comments")
    public ResponseEntity<List<CommnetSimpleResponseDto>> getComments(@PathVariable Long todoId){
        return ResponseEntity.ok(commentService.getComments(todoId));
    }

    //댓글 단건 조회
    @GetMapping("todos/comments/{commentId}")
    public CommentDetailResponseDto getDetailComments(@PathVariable Long commentId){
        return commentService.getDetailComments(commentId);
    }
}
