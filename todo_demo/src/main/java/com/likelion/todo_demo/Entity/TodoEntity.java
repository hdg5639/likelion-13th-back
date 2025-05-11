package com.likelion.todo_demo.Entity;

import com.likelion.todo_demo.DTO.TodoDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "todo")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    public TodoDTO toDTO() {
        return TodoDTO.builder().id(id).title(title).build();
    }
}
