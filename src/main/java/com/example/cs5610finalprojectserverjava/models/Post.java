package com.example.cs5610finalprojectserverjava.models;

import javax.persistence.*;

@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String postText;
    private Integer likes;
    private Long userId;

    // Id of the quote or collection the post is for
    private Long collectionId;

    public Post(Long id, String postText, Integer likes, Long userId, Long collectionId) {
        this.id = id;
        this.postText = postText;
        this.likes = likes;
        this.userId = userId;
        this.collectionId = collectionId;
    }

    public Post() {}



    // TODO: Decide on if having list of Quote IDs as field makes sense.
    // Would be one element list if quote post and multiple quotes if collection

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCollectionId() {
        return collectionId;
    }

    public void setContentId(Long collectionId) {
        this.collectionId = collectionId;
    }
}
