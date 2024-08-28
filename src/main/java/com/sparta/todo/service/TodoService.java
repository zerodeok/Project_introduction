package com.sparta.todo.service;

import com.sparta.todo.dto.todo.*;
import com.sparta.todo.entity.Todo;
import com.sparta.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;


    @Transactional
    public TodoSaveResponseDto saveTodo(TodoSaveRequestDto todoSaveRequestDto) {
        Todo newtodo = new Todo(todoSaveRequestDto);
        Todo savedTodo = todoRepository.save(newtodo);
        return new TodoSaveResponseDto(savedTodo);
    }



    public TodoDetailResponseDto getTodo(Long todoId) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new NullPointerException("아이디가 존재 하지 않습니다."));

        return new TodoDetailResponseDto(todo);
    }

    @Transactional
    public TodoUpdateResponseDto updateTodo(Long todoId, TodoUpdateRequestDto todoUpdateRequestDto) {
        Todo updateTodo = todoRepository.findById(todoId).orElseThrow(() -> new NullPointerException("아이디가 존재 하지 않습니다."));
        updateTodo.update(todoUpdateRequestDto);

        return new TodoUpdateResponseDto(updateTodo);
    }

    @Transactional
    public void deleteTodo(Long todoId) {

        if(todoRepository.existsById(todoId)){
            throw new NullPointerException("NULL 값이 들어왔습니다.");
        }
        todoRepository.deleteById(todoId);
    }
}
