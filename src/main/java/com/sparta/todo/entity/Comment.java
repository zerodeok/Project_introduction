package com.sparta.todo.entity;


import com.sparta.todo.dto.comment.CommentUpdateRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "comment")
public class Comment extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    private String comment;
    private String userName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todoId")
    private Todo todo;

    public Comment(String comment,String userName,Todo todo){
        this.comment = comment;
        this.userName = userName;

        this.todo = todo;
    }

    public void update(CommentUpdateRequestDto commentUpdateRequestDto) {
        this.userName = commentUpdateRequestDto.getUserName();
        this.comment = commentUpdateRequestDto.getComment();
    }
}
