package com.example.cs5610finalprojectserverjava.services;

import com.example.cs5610finalprojectserverjava.models.Post;
import com.example.cs5610finalprojectserverjava.models.QuotePost;
import com.example.cs5610finalprojectserverjava.repositories.PostRepository;
import com.example.cs5610finalprojectserverjava.repositories.QuotePostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuotePostService {

    @Autowired
    QuotePostRepository repository;

    public List<QuotePost> findAllQuotePosts() {
        return (List<QuotePost>) repository.findAll();
    }

    public List<QuotePost> findQuotePostsForQuote(String quoteId) {
        return repository.findQuotePostsForQuote(quoteId);
    }

    public List<QuotePost> findQuotePostsForUser(Long userId) {
        return repository.findQuotePostsForUser(userId);
    }

//    public Post createPostForUser(Long userId, Post post) {
//        post.setUserId(userId);
//        return repository.save(post);
//    }

    public QuotePost createPostOnQuote(String quoteId, QuotePost post) {
        post.setQuoteId(quoteId);
        return repository.save(post);
    }

    public Integer deleteQuotePost(Long postId) {
        repository.deleteById(postId);
        return 1;
    }

    public Integer updateQuotePost(Long postId, QuotePost post) {
        if(repository.findById(postId).isPresent()) {
            QuotePost originalPost = repository.findById(postId).get();

            if (post.getPostText() != null) {
                originalPost.setPostText(post.getPostText());
            }

            if (post.getUserId() != null) {
                originalPost.setUserId(post.getUserId());
            }

            if (post.getLikes() != null) {
                originalPost.setLikes(post.getLikes());
            }

            if (post.getQuoteId() != null) {
                originalPost.setQuoteId(post.getQuoteId());
            }


            repository.save(originalPost);

        }
        return 1;
    }
}
