package com.likelion.todo_demo.DAO;

import com.likelion.todo_demo.DTO.NewTodoDTO;
import com.likelion.todo_demo.DTO.TodoDTO;
import com.likelion.todo_demo.Entity.TodoEntity;
import com.likelion.todo_demo.Exception.CustomException;
import com.likelion.todo_demo.Repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TodoDAOImpl implements TodoDAO {
    private final TodoRepository todoRepository;

    @Override
    public TodoDTO addTodo(NewTodoDTO newTodoDTO) {
        if (newTodoDTO.getTitle().isEmpty() || newTodoDTO.getTitle().isBlank()) {
            throw new IllegalArgumentException("내용이 없습니다.");
        } else {
            return todoRepository.save(TodoEntity.builder()
                    .title(newTodoDTO.getTitle())
                    .build())
                    .toDTO();
        }
    }

    @Override
    public List<TodoDTO> getAllTodos() {
        return todoRepository.findAll()
                .stream().map(TodoEntity::toDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteTodo(Long id) {
        if (!todoRepository.existsById(id)) {
            throw new IllegalArgumentException("잘못된 id");
        }
        todoRepository.deleteById(id);
    }
}
