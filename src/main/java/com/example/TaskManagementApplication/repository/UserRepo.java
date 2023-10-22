package com.example.TaskManagementApplication.repository;

import com.example.TaskManagementApplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findUserById(Long id);
    void deleteUserById(Long id);

}
