package com.sparta.todo.entity;


import com.sparta.todo.dto.todo.TodoSaveRequestDto;
import com.sparta.todo.dto.todo.TodoUpdateRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "todo")
public class Todo extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long todoId;
    private String userName;
    private String title;
    private String todo;

    @OneToMany(mappedBy = "todo")
    private List<Comment> comments = new ArrayList<>();

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
