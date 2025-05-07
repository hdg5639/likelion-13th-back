package com.likelion.demo.Service.Book;

import com.likelion.demo.DTO.Book.BookDTO;
import com.likelion.demo.DTO.Book.CreateBookDTO;

import java.util.List;

public interface BookService {
    BookDTO createBook(CreateBookDTO createBookDTO);
    List<BookDTO> allBooks();
    BookDTO findBookByTitle(String title);
    BookDTO findBookById(Long id);
    BookDTO updateBook(BookDTO bookDTO);
    void deleteBook(Long id);
}
