package com.example.cs5610finalprojectserverjava.repositories;

import com.example.cs5610finalprojectserverjava.models.Post;
import com.example.cs5610finalprojectserverjava.models.QuotePost;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuotePostRepository extends CrudRepository<QuotePost, Long> {

    @Query(value = "SELECT * FROM quote_posts WHERE quote_id=:qid", nativeQuery = true)
    public List<QuotePost> findQuotePostsForQuote(@Param("qid") String quoteId);

    @Query(value = "SELECT * FROM quote_posts WHERE user_id=:uid", nativeQuery = true)
    public List<QuotePost> findQuotePostsForUser(@Param("uid") Long userId);
}
