package com.example.cs5610finalprojectserverjava.services;

import com.example.cs5610finalprojectserverjava.models.User;
import com.example.cs5610finalprojectserverjava.repositories.UserRepository;
import com.mysql.cj.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

//    private List<User> users = new ArrayList<User>();
//    {
//        User u1 = new User(123l, "usernametest",
//                "password", "first",
//                "last", "em@ail.com", true);
//
//        users.add(u1);
//    }

    public List<User> findAllUsers() {
        return (List<User>) repository.findAll();
    }

    public User findUserById(Long id) {
        return repository.findById(id).get();
    }

//    public User findUserByUsername(String username) {
//        return repository.findUserByUsername(username);
//    }

    public User loginUser(String username, String password) {
        User existingUser = repository.findUserByCredentials(username, password);
        if (existingUser != null) {
            return existingUser;
        } else {
            return new User();
//            return null;
        }
        //return repository.findUserByCredentials(username, password);
    }

    public User registerUser(User user) {
        User existingUser = repository.findUserByUsername(user.getUsername());
        if (existingUser == null) {
            User newUser = repository.save(user);
            return newUser;
        } else {
            // returns empty user is already exists.
            return new User();
//            return null;
        }
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
                User nameCheck = repository.findUserByUsername(user.getUsername());
                if (nameCheck == null || nameCheck.getId() == id) {
                    originalUser.setUsername(user.getUsername());
                } else {
                    return -1;
                }
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

            if (user.getBio() != null) {
                originalUser.setBio(user.getBio());
            }

            if (user.getFollowedCollections() != null) {
                originalUser.setFollowedCollections(user.getFollowedCollections());
            }

            if (user.getPhoneNum() != null) {
                originalUser.setPhoneNum(user.getPhoneNum());
            }

            repository.save(originalUser);
        }
        return 1;
    }

}
