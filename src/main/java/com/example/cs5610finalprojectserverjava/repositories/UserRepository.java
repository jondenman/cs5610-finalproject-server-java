package com.example.cs5610finalprojectserverjava.repositories;

import com.example.cs5610finalprojectserverjava.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
