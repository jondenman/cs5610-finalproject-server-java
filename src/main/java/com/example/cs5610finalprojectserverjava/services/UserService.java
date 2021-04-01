package com.example.cs5610finalprojectserverjava.services;

import com.example.cs5610finalprojectserverjava.models.User;
import com.example.cs5610finalprojectserverjava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    private List<User> users = new ArrayList<User>();
    {
        User u1 = new User(123l, "usernametest",
                "password", "first",
                "last", "em@ail.com", true);

        users.add(u1);
    }

    public List<User> findAllUsers() {
        return (List<User>) repository.findAll();
    }

    // TODO: Add CRUD operations for users
}
