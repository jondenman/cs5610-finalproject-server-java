package com.example.cs5610finalprojectserverjava.repositories;

import com.example.cs5610finalprojectserverjava.models.Collection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CollectionRepository extends CrudRepository<Collection, Long> {

    @Query(value = "SELECT * FROM collections WHERE userId=:uid", nativeQuery = true)
    public List<Collection> findCollectionsForUser(@Param("uid") Long userId);
}
