package com.likelion.demo.DTO;

import com.likelion.demo.DTO.Book.BookDTO;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDetailDTO {
    private Long id;
    private String name;
    private List<BookDTO> books;
}
