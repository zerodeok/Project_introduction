package com.sparta.todo.dto.todo;

import com.sparta.todo.entity.Todo;
import lombok.Getter;

import java.time.LocalDateTime;


@Getter
public class TodoDetailResponseDto {

    private final Long id;
    private final String userName;
    private final String title;
    private final String todo;
    private final LocalDateTime updated_at;
    private final LocalDateTime created_at;

    public TodoDetailResponseDto(Todo todo) {
        this.id = todo.getId();
        this.userName = todo.getUserName();
        this.title = todo.getTitle();
        this.todo = todo.getTodo();
        this.created_at = todo.getCreated_at();
        this.updated_at = todo.getUpdated_at();
    }
}
