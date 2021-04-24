package com.example.cs5610finalprojectserverjava.controllers;

import com.example.cs5610finalprojectserverjava.models.User;
import com.example.cs5610finalprojectserverjava.services.UserService;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
//@CrossOrigin(origins = {"https://cs5610-final-project-client.herokuapp.com"}, allowCredentials = "true")
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
            @RequestBody User credentials, HttpSession session) {
        return service.registerUser(credentials);
//        User newUser = service.registerUser(credentials);
//        if (newUser == null) {
//            return null;
//        } else {
//            session.setAttribute("profile", newUser);
//            return newUser;
//        }
    }

    @PostMapping("/api/users/login")
    public User loginUser(
            @RequestBody User credentials, HttpSession session) {
        return service.loginUser(credentials.getUsername(), credentials.getPassword());
//        User existingUser =  service.loginUser(credentials.getUsername(), credentials.getPassword());
//        if (existingUser != null) {
//            session.setAttribute("profile", existingUser);
//            return existingUser;
//        } else {
//            return null;
//        }
    }

    @PostMapping("/api/users/profile")
    public User profile(HttpSession session) {
        User currentUser = (User)session.getAttribute("profile");
        return currentUser;
    }

    @PostMapping("/api/users/logout")
    public void logout(HttpSession session) {
        session.invalidate();
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
