package com.sparta.todo.dto.comment;


import com.sparta.todo.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentUpdateResponseDto {

    private final Long CommentId;
    private final String comment;
    private final String userName;
    private final LocalDateTime updated_at;
    private final LocalDateTime created_at;

    public CommentUpdateResponseDto(Comment comment) {
        this.CommentId = comment.getCommentId();
        this.comment = comment.getComment();
        this.userName = comment.getUserName();
        this.updated_at = comment.getUpdated_at();
        this.created_at = comment.getCreated_at();
    }
}
