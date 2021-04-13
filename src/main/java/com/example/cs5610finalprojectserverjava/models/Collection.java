package com.example.cs5610finalprojectserverjava.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="collections")
public class Collection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String collectionName;
    private Integer likes;

    @ElementCollection
    private List<Long> quoteIds;
    private Long userId;


    public Collection(Long id, String collectionName, Integer likes, List<Long> quoteIds, Long userId) {
        this.id = id;
        this.collectionName = collectionName;
        this.likes = likes;
        this.quoteIds = quoteIds;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public List<Long> getQuoteIds() {
        return quoteIds;
    }

    public void setQuoteIds(List<Long> quoteIds) {
        this.quoteIds = quoteIds;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
