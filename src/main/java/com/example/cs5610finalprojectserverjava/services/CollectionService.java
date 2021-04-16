package com.example.cs5610finalprojectserverjava.services;

import com.example.cs5610finalprojectserverjava.models.Collection;
import com.example.cs5610finalprojectserverjava.models.User;
import com.example.cs5610finalprojectserverjava.repositories.CollectionRepository;
import com.example.cs5610finalprojectserverjava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CollectionService {

    @Autowired
    CollectionRepository repository;

    public List<Collection> findAllCollections() {
        return (List<Collection>) repository.findAll();
    }

    public Collection findCollectionById(Long id) {
        return repository.findById(id).get();
    }

    public List<Collection> findCollectionsForUser(Long userId) {
        return repository.findCollectionsForUser(userId);
    }

    public List<Collection> findFollowedCollectionsForUser(Long userId) {
        return repository.findCollectionsFollowedByUser(userId);
//        List<Collection> results = new ArrayList<>();
//        for ()
    }

    public Collection createCollectionForUser(Long userId, Collection collection) {
        collection.setUserId(userId);
        if (repository.findCollectionByCollectionName(collection.getCollectionName()) == null) {
            return repository.save(collection);
        } else {
            return new Collection();
        }
    }

    public Integer deleteCollection(Long id) {
        repository.deleteById(id);
        return 1;
    }

    public Integer updateCollection(Long id, Collection collection) {
        if (repository.findById(id).isPresent()) {

            Collection originalCollection = repository.findById(id).get();

            if (collection.getCollectionName() != null) {
                originalCollection.setCollectionName(collection.getCollectionName());
            }

            if (collection.getLikes() != null) {
                originalCollection.setLikes(collection.getLikes());
            }

            if (collection.getQuoteIds() != null) {
                originalCollection.setQuoteIds(collection.getQuoteIds());
            }

            if (collection.getUserId() != null) {
                originalCollection.setUserId(collection.getUserId());
            }

            repository.save(originalCollection);
        }
        return 1;
    }

}
