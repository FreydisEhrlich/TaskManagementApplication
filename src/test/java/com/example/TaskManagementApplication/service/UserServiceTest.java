package com.example.TaskManagementApplication.service;

import com.example.TaskManagementApplication.model.User;
import com.example.TaskManagementApplication.repository.UserRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    private UserRepo userRepository;
    private UserService underTest;

    @BeforeEach
    void setup(){
        underTest = new UserService(userRepository);
    }

    @Test
    void findAllUsers() {
        underTest.findAllUsers();
        verify(userRepository).findAll();
    }

   @Test
    void addUser() {
        //given
        User user = new User("Mary", "mary@email.com");

        //when
        underTest.addUser(user);
        ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);
        verify(userRepository).save(userArgumentCaptor.capture());
        User capturedStudent = userArgumentCaptor.getValue();
        assertThat(capturedStudent).isEqualTo(user);
    }

}