package com.example.cs5610finalprojectserverjava.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String bio;

    @ElementCollection
    private List<Long> followedCollections;

    // Check if true, show my collections
    private Boolean isPremium;

    // constructor with all params
    public User(long id, String username, String password, String firstName,
                String lastName, String email, Boolean isPremium, String bio,
                List<Long> followedCollections) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.isPremium = isPremium;
        this.bio = bio;
        this.followedCollections = followedCollections;
    }

    // empty constructor
    public User() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getPremium() {
        return isPremium;
    }

    public void setPremium(Boolean premium) {
        isPremium = premium;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public List<Long> getFollowedCollections() {
        return followedCollections;
    }

    public void setFollowedCollections(List<Long> followedCollections) {
        this.followedCollections = followedCollections;
    }
}

