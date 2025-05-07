package com.likelion.demo.Service.Book;

import com.likelion.demo.DAO.Book.BookDAO;
import com.likelion.demo.DTO.Book.BookDTO;
import com.likelion.demo.DTO.Book.CreateBookDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookDAO bookDAO;

    @Override
    public BookDTO createBook(CreateBookDTO createBookDTO) {
        try {
            return bookDAO.addBook(createBookDTO);
        } catch (Exception e) {
            throw new RuntimeException("Book already exists");
        }
    }

    @Override
    public List<BookDTO> allBooks() {
        return bookDAO.getAllBooks();
    }

    @Override
    public BookDTO findBookByTitle(String title) {
        return bookDAO.findByTitle(title);
    }

    @Override
    public BookDTO findBookById(Long id) {
        return bookDAO.findById(id);
    }

    @Override
    public BookDTO updateBook(BookDTO bookDTO) {
        return bookDAO.updateBook(bookDTO);
    }

    @Override
    public void deleteBook(Long id) {
        bookDAO.deleteBook(id);
    }
}
