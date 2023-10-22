package com.example.TaskManagementApplication.resources;

import com.example.TaskManagementApplication.model.Todo;
import com.example.TaskManagementApplication.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TodoResource {
    private final TodoService todoService;

    public TodoResource(TodoService todoService){
        this.todoService = todoService;
    }

    @PostMapping("/add")
    public ResponseEntity<Todo> addTask(@RequestBody Todo todo){
        Todo newTask = todoService.addTask(todo);
        return new ResponseEntity<>(newTask, HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Todo> getTaskById(@PathVariable("id") Long id){
        Todo todo = todoService.findByTaskId(id);
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    @GetMapping("/find/{title}")
    public ResponseEntity<Todo> getTaskByTitle(@PathVariable("title") String title){
        Todo todo = todoService.findByTitle(title);
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Todo> updateTask(@RequestBody Todo todo){
        Todo updatedTask = todoService.updateTask(todo);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable("id") Long id){
        todoService.deleteTaskById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
