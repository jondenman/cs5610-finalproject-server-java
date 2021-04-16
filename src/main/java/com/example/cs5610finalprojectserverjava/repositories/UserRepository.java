package com.example.cs5610finalprojectserverjava.repositories;

import com.example.cs5610finalprojectserverjava.models.Post;
import com.example.cs5610finalprojectserverjava.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    public User findUserByUsername(String username);

    @Query(value = "SELECT * FROM users WHERE username=:usrname and password=:pw", nativeQuery = true)
    public User findUserByCredentials(@Param("usrname") String username, @Param("pw") String password);
}
