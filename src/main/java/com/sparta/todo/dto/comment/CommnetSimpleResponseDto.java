package com.sparta.todo.dto.comment;


import com.sparta.todo.entity.Comment;
import lombok.Getter;

@Getter
public class CommnetSimpleResponseDto {

    private final Long CommentId;
    private final String comment;
    private final String userName;

    public CommnetSimpleResponseDto(Comment comment) {
        this.CommentId = comment.getCommentId();
        this.comment = comment.getComment();
        this.userName = comment.getUserName();
    }
}
