package com.example.TaskManagementApplication.repository;

import com.example.TaskManagementApplication.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ToDoRepo extends JpaRepository<Todo, Long> {
    Optional<Todo> findByTitle(String title);
    Optional<Todo> findByTaskId(Long id);
    void deleteTaskById(Long id);
}
