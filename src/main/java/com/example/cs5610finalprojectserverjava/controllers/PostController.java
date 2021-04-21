package com.example.cs5610finalprojectserverjava.controllers;

import com.example.cs5610finalprojectserverjava.models.Post;
import com.example.cs5610finalprojectserverjava.services.PostService;
import com.example.cs5610finalprojectserverjava.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = {"http://localhost:3000"})
@CrossOrigin(origins = {"*"})
public class PostController {
    @Autowired
    PostService service;

    @GetMapping("/api/collections/posts")
    public List<Post> findAllPosts() {
        return service.findAllPosts();
    }

    @GetMapping("/api/collections/{cid}/posts")
    public List<Post> findPostsForCollection(
            @PathVariable("cid") Long collectionId) {
        return service.findPostsForContent(collectionId);
    }

//    @GetMapping("/api/quotes/{qid}/posts")
//    public List<Post> findPostsForQuote(
//            @PathVariable("qid") Long quoteId) {
//        return service.findPostsForContent(quoteId);
//    }

    @GetMapping("api/users/{uid}/collections/posts")
    public List<Post> findPostsForUser(
            @PathVariable("uid") Long userId) {
        return service.findPostsForUser(userId);
    }

//    @PostMapping("/api/users/{uid}/posts")
//    public Post createPostForUser(
//        @PathVariable("uid") Long userId,
//        @RequestBody Post post) {
//        return service.createPostForUser(userId, post);
//    }

    @PostMapping("api/collections/{cid}/posts")
    public Post createPostOnCollection(
            @PathVariable("cid") Long collectionId,
            @RequestBody Post post) {
        return service.createPostOnCollection(collectionId, post);
    }

//    @PostMapping("api/quotes/{qid}/posts")
//    public Post createPostOnQuote(
//            @PathVariable("qid") Long quoteId,
//            @RequestBody Post post) {
//        return service.createPostOnQuote(quoteId, post);
//    }

    @DeleteMapping("/api/collections/posts/{pid}")
    public Integer deletePost(
            @PathVariable("pid") Long id) {
        return service.deletePost(id);
    }

    @PutMapping("/api/collections/posts/{pid}")
    public Integer updatePost(
            @PathVariable("pid") Long id,
            @RequestBody Post post) {
        return service.updatePost(id, post);
    }

}
