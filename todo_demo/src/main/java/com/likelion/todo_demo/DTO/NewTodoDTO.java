package com.likelion.todo_demo.DTO;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NewTodoDTO {
    private String title;
}
