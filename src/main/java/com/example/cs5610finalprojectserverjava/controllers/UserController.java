package com.example.cs5610finalprojectserverjava.controllers;

import com.example.cs5610finalprojectserverjava.models.User;
import com.example.cs5610finalprojectserverjava.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("/api/users")
    public List<User> findAllUsers() {
        return service.findAllUsers();
    }
}
