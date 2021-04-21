package com.example.cs5610finalprojectserverjava.controllers;

import com.example.cs5610finalprojectserverjava.models.Post;
import com.example.cs5610finalprojectserverjava.models.QuotePost;
import com.example.cs5610finalprojectserverjava.services.PostService;
import com.example.cs5610finalprojectserverjava.services.QuotePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = {"http://localhost:3000"})
@CrossOrigin(origins = {"*"})
public class QuotePostController {
    @Autowired
    QuotePostService service;

    @GetMapping("/api/quotes/posts")
    public List<QuotePost> findAllQuotePosts() {
        return service.findAllQuotePosts();
    }


    @GetMapping("/api/quotes/{qid}/posts")
    public List<QuotePost> findQuotePostsForQuote(
            @PathVariable("qid") String quoteId) {
        return service.findQuotePostsForQuote(quoteId);
    }

    @GetMapping("api/users/{uid}/quotes/posts")
    public List<QuotePost> findQuotePostsForUser(
            @PathVariable("uid") Long userId) {
        return service.findQuotePostsForUser(userId);
    }

    @PostMapping("api/quotes/{qid}/posts")
    public QuotePost createPostOnQuote(
            @PathVariable("qid") String quoteId,
            @RequestBody QuotePost post) {
        return service.createPostOnQuote(quoteId, post);
    }

    @DeleteMapping("/api/quotes/posts/{pid}")
    public Integer deleteQuotePost(
            @PathVariable("pid") Long id) {
        return service.deleteQuotePost(id);
    }

    @PutMapping("/api/quotes/posts/{pid}")
    public Integer updatePost(
            @PathVariable("pid") Long id,
            @RequestBody QuotePost post) {
        return service.updateQuotePost(id, post);
    }

}
