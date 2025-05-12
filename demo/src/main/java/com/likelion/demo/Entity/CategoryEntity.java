package com.likelion.demo.Entity;

import com.likelion.demo.DTO.CategoryDTO;
import com.likelion.demo.DTO.CategoryDetailDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "category")
    private List<BookEntity> books = new ArrayList<>();

    public CategoryDTO toDTO() {
        return CategoryDTO.builder()
                .id(id)
                .name(name)
                .build();
    }

    public CategoryDetailDTO toDetailDTO() {
        return CategoryDetailDTO.builder()
                .id(id)
                .name(name)
                .books(books.stream().map(BookEntity::toDTO).toList())
                .build();
    }
}
