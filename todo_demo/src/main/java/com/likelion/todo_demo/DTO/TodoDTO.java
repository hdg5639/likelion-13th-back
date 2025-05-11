package com.likelion.todo_demo.DTO;

import lombok.*;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TodoDTO {
    private Long id;
    private String title;
}
