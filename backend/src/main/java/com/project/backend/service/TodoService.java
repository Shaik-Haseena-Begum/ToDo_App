package com.project.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.backend.model.Todo;
import com.project.backend.repository.TodoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TodoService {

    private final TodoRepository todoRepository;  

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }  

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }   

    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }  
    
    public Todo update(Long id, Todo todo) {
        if (todoRepository.existsById(id)) {
            todo.setId(id);
            return todoRepository.save(todo);
        } else {
            throw new EntityNotFoundException("Todo not found with id: " + id);
        }
    }
    public void delete(Long id) {
        if (todoRepository.existsById(id)) {
            todoRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Todo not found with id: " + id);
        }
    }   
}
