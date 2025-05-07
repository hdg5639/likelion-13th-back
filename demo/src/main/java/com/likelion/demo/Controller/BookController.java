package com.likelion.demo.Controller;

import com.likelion.demo.DTO.Book.BookDTO;
import com.likelion.demo.DTO.Book.CreateBookDTO;
import com.likelion.demo.Service.Book.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    // 책 추가 (예외 처리 예시로 넣어둠)
    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody CreateBookDTO bookDTO) {
        try {
            return ResponseEntity.ok(bookService.createBook(bookDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // 전체 조회
    @GetMapping("/all")
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        return ResponseEntity.ok(bookService.allBooks());
    }

    // 타이틀로 조회
    @GetMapping("/title")
    public ResponseEntity<BookDTO> getBookByTitle(@RequestParam String title) {
        return ResponseEntity.ok(bookService.findBookByTitle(title));
    }

    // id로 조회
    @GetMapping("/id")
    public ResponseEntity<BookDTO> getBookById(@RequestParam Long id) {
        return ResponseEntity.ok(bookService.findBookById(id));
    }

    @PutMapping
    public ResponseEntity<BookDTO> updateBook(@RequestBody BookDTO bookDTO) {
        return ResponseEntity.ok(bookService.updateBook(bookDTO));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteBook(@RequestParam Long id) {
        try {
            bookService.deleteBook(id);
            return ResponseEntity.ok("삭제 성공");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
