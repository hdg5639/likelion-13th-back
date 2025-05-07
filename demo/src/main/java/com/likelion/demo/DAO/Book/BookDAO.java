package com.likelion.demo.DAO.Book;

import com.likelion.demo.DTO.Book.BookDTO;
import com.likelion.demo.DTO.Book.CreateBookDTO;

import java.util.List;

public interface BookDAO {
    BookDTO addBook(CreateBookDTO createBookDTO);
    List<BookDTO> getAllBooks();
    BookDTO findByTitle(String title);
    BookDTO findById(Long id);
    BookDTO updateBook(BookDTO bookDTO);
    void deleteBook(Long id);
}
