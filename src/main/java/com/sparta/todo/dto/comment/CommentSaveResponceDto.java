package com.sparta.todo.dto.comment;

import lombok.Getter;

@Getter
public class CommentSaveResponceDto {

    private final Long CommentId;
    private final String comment;
    private final String userName;

    public CommentSaveResponceDto(Long id,String comment, String userName) {
        this.CommentId = id;
        this.comment= comment;
        this.userName = userName;
    }
}
