package com.sparta.todo.service;


import com.sparta.todo.dto.comment.*;
import com.sparta.todo.entity.Comment;
import com.sparta.todo.entity.Todo;
import com.sparta.todo.repository.CommentRepository;
import com.sparta.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class CommentService {

    private final CommentRepository commentRepository;
    private final TodoRepository todoRepository;

    @Transactional
    public CommentSaveResponceDto saveComment(Long todoId, CommentSaveRequestDto commentSaveRequestDto) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new NullPointerException("일정이 존재하지 않습니다."));

        Comment newComment = new Comment(commentSaveRequestDto.getComment(), commentSaveRequestDto.getUserName(), todo);
        Comment savedComment = commentRepository.save(newComment);

        return new CommentSaveResponceDto(savedComment.getCommentId(), savedComment.getComment(), savedComment.getUserName());
    }



    public List<CommnetSimpleResponseDto> getComments(Long todoId) {
        List<Comment> commentList = commentRepository.findByTodoTodoId(todoId);

        List<CommnetSimpleResponseDto> dtoList = new ArrayList<>();
        for (Comment comment : commentList) {
            dtoList.add(new CommnetSimpleResponseDto(
                    comment.getCommentId(),
                    comment.getComment(),
                    comment.getUserName()
                    ));
        }
        return dtoList;
    }

    public CommentDetailResponseDto getDetailComments(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new NullPointerException("댓글이 존재하지 않습니다."));

        return new CommentDetailResponseDto(comment);

    }

    //댓글 수정
    @Transactional
    public CommentUpdateResponseDto updateComments(Long commentId, CommentUpdateRequestDto commentUpdateRequestDto) {
        Comment updateComment = commentRepository.findById(commentId).orElseThrow(() -> new NullPointerException("댓글이 존재하지 않습니다."));
        updateComment.update(commentUpdateRequestDto);

        return new CommentUpdateResponseDto(updateComment);
    }

    @Transactional
    public void deleteComment(Long commentId) {
        if(!commentRepository.existsById(commentId)){
            throw new NullPointerException("NULL 값이 들어왔습니다.");
        }
        commentRepository.deleteById(commentId);
    }
}
