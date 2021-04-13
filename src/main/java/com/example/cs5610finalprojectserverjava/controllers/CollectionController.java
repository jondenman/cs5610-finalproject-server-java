package com.example.cs5610finalprojectserverjava.controllers;

import com.example.cs5610finalprojectserverjava.models.Collection;
import com.example.cs5610finalprojectserverjava.services.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
public class CollectionController {

    @Autowired
    CollectionService service;

    @GetMapping("api/collections")
    public List<Collection> findAllCollections() {
        return service.findAllCollections();
    }

    @GetMapping("api/collections/{cid}")
    public Collection findCollectionById(
            @PathVariable("cid") Long id) {
        return service.findCollectionById(id);
    }

    @PostMapping("api/collections")
    public Collection createCollection(
            @RequestBody Collection collection
    ) {
        return service.createCollection(collection);
    }

    @DeleteMapping("api/collections/{cid}")
    public Integer deleteCollection(
            @PathVariable("cid") Long id) {
        return service.deleteCollection(id);
    }

    @PutMapping("api/collections/{cid}")
    public Integer updateCollection(
            @PathVariable("cid") Long id,
            @RequestBody Collection collection) {
        return service.updateCollection(id, collection);
    }
}
