package com.sparta.todo.controller;

import com.sparta.todo.dto.comment.*;
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


    //댓글 등록
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
    @GetMapping("/todos/comments/{commentId}")
    public ResponseEntity<CommentDetailResponseDto> getDetailComments(@PathVariable Long commentId){
        return ResponseEntity.ok(commentService.getDetailComments(commentId));
    }

    //댓글 수정
    @PutMapping("/todos/comments/{commentId}")
    public ResponseEntity<CommentUpdateResponseDto> updateComments(@PathVariable Long commentId, @RequestBody CommentUpdateRequestDto commentUpdateRequestDto){
        return ResponseEntity.ok(commentService.updateComments(commentId,commentUpdateRequestDto));
    }

    //댓글 삭제
    @DeleteMapping("/todos/comments/{commentId}")
    public void deleteComment(@PathVariable Long commentId){
        commentService.deleteComment(commentId);
    }
}
