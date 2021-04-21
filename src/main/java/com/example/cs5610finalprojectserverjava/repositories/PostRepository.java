package com.example.cs5610finalprojectserverjava.repositories;

import com.example.cs5610finalprojectserverjava.models.Post;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {

    @Query(value = "SELECT * FROM posts WHERE collection_id=:cid", nativeQuery = true)
    public List<Post> findPostsForContent(@Param("cid") Long collectionId);

    @Query(value = "SELECT * FROM posts WHERE user_id=:uid", nativeQuery = true)
    public List<Post> findPostsForUser(@Param("uid") Long userId);
}
