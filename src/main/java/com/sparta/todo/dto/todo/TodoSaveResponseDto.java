package com.sparta.todo.dto.todo;

import com.sparta.todo.entity.Todo;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoSaveResponseDto {

    private final Long id;
    private final String userName;
    private final String title;
    private final String todo;
    private final LocalDateTime created_at;
    private final LocalDateTime updated_at;

    public TodoSaveResponseDto(Todo saveTodo) {
        this.id = saveTodo.getId();
        this.userName = saveTodo.getUserName();
        this.title = saveTodo.getTitle();
        this.todo = saveTodo.getTodo();
        this.created_at = saveTodo.getCreated_at();
        this.updated_at = saveTodo.getUpdated_at();
    }
}
