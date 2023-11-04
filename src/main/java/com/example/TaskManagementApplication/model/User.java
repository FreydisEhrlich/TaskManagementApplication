package com.example.TaskManagementApplication.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Email
    @Column(nullable = false, unique = true)
    private String email;
    private String imageUrl;

    public User(String name, String email){
        this.name = name;
        this.email = email;
    }
}
