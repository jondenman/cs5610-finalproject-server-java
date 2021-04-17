package com.example.cs5610finalprojectserverjava.controllers;

import com.example.cs5610finalprojectserverjava.models.Collection;
import com.example.cs5610finalprojectserverjava.models.User;
import com.example.cs5610finalprojectserverjava.services.CollectionService;
import com.example.cs5610finalprojectserverjava.services.UserService;
import com.mysql.cj.xdevapi.JsonArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
public class CollectionController {

    @Autowired
    CollectionService service;

    @Autowired
    UserService userService;

    @GetMapping("api/collections")
    public List<Collection> findAllCollections() {
        return service.findAllCollections();
    }

    @GetMapping("api/collections/{cid}")
    public Collection findCollectionById(
            @PathVariable("cid") Long id) {
        return service.findCollectionById(id);
    }

    @GetMapping("api/users/{uid}/collections")
    public List<Collection> findCollectionsForUser(
            @PathVariable("uid") Long userId) {
        return service.findCollectionsForUser(userId);
    }

    @GetMapping("api/collections/list")
    public List<Collection> findCollectionsForList(
            @RequestBody User user) {
        List<Long> list = user.getFollowedCollections();
        return service.findCollectionsForList(list);
    }

    @GetMapping("api/users/{uid}/followed")
    public List<Collection> findFollowedCollectionsForUser(
            @PathVariable("uid") Long userId) {
        User user = userService.findUserById(userId);
        List<Long> list = user.getFollowedCollections();
        return service.findCollectionsForList(list);
    }

    @PostMapping("api/users/{uid}/collections")
    public Collection createCollectionForUser(
            @PathVariable("uid") Long userId,
            @RequestBody Collection collection
    ) {
        return service.createCollectionForUser(userId, collection);
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
