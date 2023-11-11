package com.example.TaskManagementApplication.service;


import com.example.TaskManagementApplication.model.Task;
import com.example.TaskManagementApplication.repository.TaskRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {

    @Mock
    private TaskRepo taskRepository;
    private TaskService underTest;

    @BeforeEach
    void setup(){
        underTest = new TaskService(taskRepository);
    }

    @Test
    void findAllTasks() {
        underTest.findAllTasks();
        verify(taskRepository).findAll();
    }

    @Test
    void addTask() {
        //given
        Task task = new Task(1L, "go to gym", true, LocalDate.of(2023, 11, 11), 12L );

        //when
        underTest.addTask(task);
        ArgumentCaptor<Task> taskArgumentCaptor = ArgumentCaptor.forClass(Task.class);
        verify(taskRepository).save(taskArgumentCaptor.capture());
        Task capturedStudent = taskArgumentCaptor.getValue();
        assertThat(capturedStudent).isEqualTo(task);
    }
}