package com.likelion.demo.Entity;

import com.likelion.demo.DTO.Book.BookDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "book")
@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String author;

    @Column
    private String publisher;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private CategoryEntity category;

    public BookDTO toDTO() {
        return BookDTO.builder()
                .id(id)
                .title(title)
                .author(author)
                .publisher(publisher)
                .build();
    }
}
