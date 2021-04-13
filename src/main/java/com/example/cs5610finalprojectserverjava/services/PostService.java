package com.example.cs5610finalprojectserverjava.services;

import com.example.cs5610finalprojectserverjava.models.Post;
import com.example.cs5610finalprojectserverjava.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepository repository;

    public List<Post> findAllPosts() {
        return (List<Post>) repository.findAll();
    }

//    public Post createPostForUser(Long userId, Post post) {
//        post.setUserId(userId);
//        return repository.save(post);
//    }

    public Post createPostOnCollection(Long collectionId, Post post) {
        post.setContentId(collectionId);
        return repository.save(post);
    }

    public Post createPostOnQuote(Long quoteId, Post post) {
        post.setContentId(quoteId);
        return repository.save(post);
    }

    public Integer deletePost(Long postId) {
        repository.deleteById(postId);
        return 1;
    }

    public Integer updatePost(Long postId, Post post) {
        if(repository.findById(postId).isPresent()) {
            Post originalPost = repository.findById(postId).get();

            if (post.getPostText() != null) {
                originalPost.setPostText(post.getPostText());
            }

            if (post.getUserId() != null) {
                originalPost.setUserId(post.getUserId());
            }

            if (post.getLikes() != null) {
                originalPost.setLikes(post.getLikes());
            }


            repository.save(originalPost);

        }
        return 1;
    }
}
