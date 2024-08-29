package com.sparta.todo.dto.todo;

import com.sparta.todo.entity.Todo;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoUpdateResponseDto {


    private final Long todoId;
    private final String userName;
    private final String title;
    private final String todo;
    private final LocalDateTime created_at;
    private final LocalDateTime updated_at;

    public TodoUpdateResponseDto(Todo updateTodo) {
        this.todoId = updateTodo.getTodoId();
        this.userName = updateTodo.getUserName();
        this.title = updateTodo.getTitle();
        this.todo = updateTodo.getTodo();
        this.created_at = updateTodo.getCreatedAt();
        this.updated_at = updateTodo.getUpdatedAt();
    }
}
