package com.sparta.todo.entity;


import com.sparta.todo.dto.todo.TodoSaveRequestDto;
import com.sparta.todo.dto.todo.TodoUpdateRequestDto;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@jakarta.persistence.Entity
@NoArgsConstructor

public class Todo extends Timestamped{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String title;
    private String todo;


    public Todo(TodoSaveRequestDto todoSaveRequestDto){
        this.userName = todoSaveRequestDto.getUserName();
        this.title = todoSaveRequestDto.getTitle();
        this.todo = todoSaveRequestDto.getTodo();
    }

    public void update(TodoUpdateRequestDto todoUpdateRequestDto){
        this.title = todoUpdateRequestDto.getTitle();
        this.todo = todoUpdateRequestDto.getTodo();
        this.userName = todoUpdateRequestDto.getUserName();
    }

}
