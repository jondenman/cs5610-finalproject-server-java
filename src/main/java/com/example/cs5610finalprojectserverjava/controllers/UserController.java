package com.example.cs5610finalprojectserverjava.controllers;

import com.example.cs5610finalprojectserverjava.models.User;
import com.example.cs5610finalprojectserverjava.services.UserService;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = {"http://localhost:3000"})
@CrossOrigin(origins = {"*"})
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("/api/users")
    public List<User> findAllUsers() {
        return service.findAllUsers();
    }

    @GetMapping("/api/users/{uid}")
    public User findUserById(
            @PathVariable("uid") Long id) {
        return service.findUserById(id);
    }

    @PostMapping("/api/users/register")
    public User registerUser(
            @RequestBody User user) {
        return service.registerUser(user);
    }

    @PostMapping("/api/users/login")
    public User loginUser(
            @RequestBody User credentials) {
        return service.loginUser(credentials.getUsername(), credentials.getPassword());
    }

    @PostMapping("/api/users")
    public User createUser(
            @RequestBody User user
    ) {
        return service.createUser(user);
    }

    @DeleteMapping("/api/users/{uid}")
    public Integer deleteUser(
            @PathVariable("uid") Long id) {
        return service.deleteUser(id);
    }

    @PutMapping("api/users/{uid}")
    public Integer updateUser(
            @PathVariable("uid") Long id,
            @RequestBody User user) {
        return service.updateUser(id, user);
    }

}
