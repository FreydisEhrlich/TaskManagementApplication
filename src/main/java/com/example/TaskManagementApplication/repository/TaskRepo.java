package com.example.TaskManagementApplication.repository;

import com.example.TaskManagementApplication.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepo extends JpaRepository<Task, Long> {
    Optional<Task> findByTitle(String title);
    Optional<Task> findById(Long id);
    void deleteTaskById(Long id);
}
