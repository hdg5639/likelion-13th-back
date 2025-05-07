package com.likelion.demo.DTO.Book;

import lombok.*;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CreateBookDTO {
    private String title;
    private String author;
    private String publisher;
}
