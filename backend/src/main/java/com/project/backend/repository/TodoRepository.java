package com.project.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.backend.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    // Custom query methods can be defined here if needed
    
}
