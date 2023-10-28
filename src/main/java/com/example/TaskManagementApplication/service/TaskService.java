package com.example.TaskManagementApplication.service;

import com.example.TaskManagementApplication.exception.TaskNotFoundException;
import com.example.TaskManagementApplication.model.Task;
import com.example.TaskManagementApplication.repository.TaskRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TaskService {
    private final TaskRepo taskRepo;

    @Autowired
    public TaskService(TaskRepo taskRepo){
        this.taskRepo = taskRepo;
    }

    public List<Task> findAllTasks(){
        return taskRepo.findAll();
    }

    public Task addTask(Task task){
        return taskRepo.save(task);
    }

    public Task findTaskById(Long id){
        return taskRepo.findTaskById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task by id " + id + " was not found"));
    }

    public Task findByTitle(String title){
        return taskRepo.findByTitle(title)
                .orElseThrow(() -> new TaskNotFoundException("Task by title " + title + " was not found"));
    }

    public Task updateTask(Task task){
        return taskRepo.save(task);
    }

    public void deleteTaskById(Long id){
        taskRepo.deleteTaskById(id);
    }
}
