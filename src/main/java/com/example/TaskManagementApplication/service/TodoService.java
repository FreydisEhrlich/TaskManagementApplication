package com.example.TaskManagementApplication.service;

import com.example.TaskManagementApplication.exception.TaskNotFoundException;
import com.example.TaskManagementApplication.model.Todo;
import com.example.TaskManagementApplication.repository.ToDoRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class TodoService {
    private final ToDoRepo toDoRepo;

    @Autowired
    public TodoService(ToDoRepo toDoRepo){
        this.toDoRepo = toDoRepo;
    }

    public Todo addTask(Todo todo){
        return toDoRepo.save(todo);
    }

    public Todo findByTaskId(Long id){
        return toDoRepo.findByTaskId(id)
                .orElseThrow(() -> new TaskNotFoundException("Task by id " + id + " was not found"));
    }

    public Todo findByTitle(String title){
        return toDoRepo.findByTitle(title)
                .orElseThrow(() -> new TaskNotFoundException("Task by title " + title + " was not found"));
    }

    public Todo updateTask(Todo todo){
        return toDoRepo.save(todo);
    }

    public void deleteTaskById(Long id){
        toDoRepo.deleteTaskById(id);
    }
}
