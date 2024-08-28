package com.sparta.todo.dto.comment;


import lombok.Getter;

@Getter
public class CommnetSimpleResponseDto {

    private final Long CommentId;
    private final String comment;
    private final String userName;

    public CommnetSimpleResponseDto(Long commentId, String comment, String userName) {
        this.CommentId = commentId;
        this.comment = comment;
        this.userName = userName;
    }
}
