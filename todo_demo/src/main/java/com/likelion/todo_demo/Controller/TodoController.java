package com.likelion.todo_demo.Controller;

import com.likelion.todo_demo.DTO.NewTodoDTO;
import com.likelion.todo_demo.DTO.TodoDTO;
import com.likelion.todo_demo.Service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/todo")
@CrossOrigin("http://localhost:3000")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoDTO> createTodo(@RequestBody NewTodoDTO newTodoDTO) {
        return ResponseEntity.ok(todoService.createTodo(newTodoDTO));
    }

    @GetMapping
    public ResponseEntity<List<TodoDTO>> getAllTodos() {
        return ResponseEntity.ok(todoService.getAllTodos());
    }

    @DeleteMapping
    public ResponseEntity<Map<String, String>> deleteTodo(@RequestParam("id") Long id){
        todoService.deleteTodo(id);
        return ResponseEntity.ok(Map.of("status", "deleted"));
    }
}
