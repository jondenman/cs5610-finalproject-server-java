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

    public User findUserById(Long id) {
        return repository.findById(id).get();
    }

    public User createUser(User user) {
        return repository.save(user);
    }

    public Integer deleteUser(Long id) {
        repository.deleteById(id);
        return 1;
    }

    public Integer updateUser(Long id, User user) {
        if (repository.findById(id).isPresent()) {
            User originalUser = repository.findById(id).get();

            if (user.getUsername() != null) {
                originalUser.setUsername(user.getUsername());
            }

            if (user.getEmail() != null) {
                originalUser.setEmail(user.getEmail());
            }

            if (user.getFirstName() != null) {
                originalUser.setFirstName(user.getFirstName());
            }

            if (user.getLastName() != null) {
                originalUser.setLastName(user.getLastName());
            }

            if (user.getPremium() != null) {
                originalUser.setPremium(user.getPremium());
            }

            if (user.getPassword() != null) {
                originalUser.setPassword(user.getPassword());
            }

            repository.save(originalUser);
            // TODO: update all fields for non null fields
        }
        return 1;
    }

    // TODO: Add CRUD operations for users
}
