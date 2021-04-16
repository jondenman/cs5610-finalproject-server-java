package com.example.cs5610finalprojectserverjava.repositories;

import com.example.cs5610finalprojectserverjava.models.Collection;
import com.example.cs5610finalprojectserverjava.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CollectionRepository extends CrudRepository<Collection, Long> {

    @Query(value = "SELECT * FROM collections WHERE user_id=:uid", nativeQuery = true)
    public List<Collection> findCollectionsForUser(@Param("uid") Long userId);

    public Collection findCollectionByCollectionName(String collectionName);

    @Query(value = "SELECT id, collection_name, likes, collections.user_id " +
            "FROM user_followed_collections " +
            "JOIN quote_test.collections " +
            "ON collections.id = user_followed_collections.followed_collections " +
            "WHERE user_followed_collections.user_id=:uid", nativeQuery = true)
    public List<Collection> findCollectionsFollowedByUser(@Param("uid") Long userId);
    // make get all collections in collection id list
}
