package com.sparta.todo.dto.todo;

import lombok.Getter;

@Getter
public class TodoUpdateRequestDto {
    private String userName;
    private String title;
    private String todo;
}
