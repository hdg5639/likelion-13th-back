package com.likelion.todo_demo.DAO;

import com.likelion.todo_demo.DTO.NewTodoDTO;
import com.likelion.todo_demo.DTO.TodoDTO;

import java.util.List;

public interface TodoDAO {
    TodoDTO addTodo(NewTodoDTO newTodoDTO);
    List<TodoDTO> getAllTodos();
    void deleteTodo(Long id);
}
