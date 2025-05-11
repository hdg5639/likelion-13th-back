package com.likelion.todo_demo.Service;

import com.likelion.todo_demo.DAO.TodoDAO;
import com.likelion.todo_demo.DTO.NewTodoDTO;
import com.likelion.todo_demo.DTO.TodoDTO;
import com.likelion.todo_demo.Exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {
    private final TodoDAO todoDAO;

    @Override
    public TodoDTO createTodo(NewTodoDTO newTodoDTO) {
        try {
            return todoDAO.addTodo(newTodoDTO);
        } catch (Exception e) {
            throw new CustomException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<TodoDTO> getAllTodos() {
        try {
            return todoDAO.getAllTodos();
        } catch (Exception e) {
            throw new CustomException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public void deleteTodo(Long id) {
        try {
            todoDAO.deleteTodo(id);
        } catch (Exception e) {
            throw new CustomException(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
