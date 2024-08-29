package com.sparta.todo.dto.comment;

import com.sparta.todo.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentDetailResponseDto {

    private final Long CommentId;
    private final String comment;
    private final String userName;
    private final LocalDateTime updated_at;
    private final LocalDateTime created_at;

    public CommentDetailResponseDto(Comment comment) {
        CommentId = comment.getCommentId();
        this.comment = comment.getComment();
        this.userName = comment.getUserName();
        updated_at = comment.getUpdatedAt();
        created_at = comment.getCreatedAt();
    }
}
