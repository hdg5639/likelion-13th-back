package com.likelion.todo_demo.Service;

import com.likelion.todo_demo.DTO.NewTodoDTO;
import com.likelion.todo_demo.DTO.TodoDTO;

import java.util.List;

public interface TodoService {
    TodoDTO createTodo(NewTodoDTO newTodoDTO);
    List<TodoDTO> getAllTodos();
    void deleteTodo(Long id);
}
