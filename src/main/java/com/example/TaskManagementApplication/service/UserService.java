package com.example.TaskManagementApplication.service;

import com.example.TaskManagementApplication.Exception.UserNotFoundException;
import com.example.TaskManagementApplication.model.User;
import com.example.TaskManagementApplication.repository.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public List<User> findAllUsers(){
        return userRepo.findAll();
    }

    public User addUser(User user){
        return userRepo.save(user);
    }

    public User findUserById(Long id){
        return userRepo.findUserById(id)
        .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

}
