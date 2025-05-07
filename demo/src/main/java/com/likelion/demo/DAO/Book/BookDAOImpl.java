package com.likelion.demo.DAO.Book;

import com.likelion.demo.DTO.Book.BookDTO;
import com.likelion.demo.DTO.Book.CreateBookDTO;
import com.likelion.demo.Entity.BookEntity;
import com.likelion.demo.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BookDAOImpl implements BookDAO {
    private final BookRepository bookRepository;

    @Override
    public BookDTO addBook(CreateBookDTO createBookDTO) {
        return bookRepository.save(BookEntity.builder()
                .title(createBookDTO.getTitle())
                .author(createBookDTO.getAuthor())
                .publisher(createBookDTO.getPublisher())
                .build()).toDTO();
    }

    @Override
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream().map(BookEntity::toDTO).toList();
    }

    @Override
    public BookDTO findByTitle(String title) {
        return bookRepository.findByTitle(title).toDTO();
    }

    @Override
    public BookDTO findById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invalid Id")).toDTO();
    }

    @Override
    public BookDTO updateBook(BookDTO bookDTO) {
        BookEntity bookEntity = bookRepository.findById(bookDTO.getId())
                .orElseThrow(() -> new RuntimeException("Invalid Id"));
        bookEntity.setTitle(bookDTO.getTitle());
        bookEntity.setAuthor(bookDTO.getAuthor());
        bookEntity.setPublisher(bookDTO.getPublisher());
        return bookRepository.save(bookEntity).toDTO();
    }

    @Override
    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id))
            throw new RuntimeException("Invalid Id");
        bookRepository.deleteById(id);
    }
}
