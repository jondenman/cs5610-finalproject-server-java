package com.example.cs5610finalprojectserverjava.controllers;

import com.example.cs5610finalprojectserverjava.models.Quote;
import com.example.cs5610finalprojectserverjava.services.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = {"http://localhost:3000"})
@CrossOrigin(origins = {"*"})
public class QuoteController {

    @Autowired
    QuoteService service;

    @GetMapping("api/quotes")
    public List<Quote> findAllQuotes() {
        return service.findAllQuotes();
    }

    @GetMapping("api/quotes/{qid}")
    public Quote findQuoteById(
            @PathVariable("qid") String id) {
        return service.findQuoteById(id);
    }

    @PostMapping("api/quotes")
    public Quote createQuote(
            @RequestBody Quote quote
    ) {
        return service.createQuote(quote);
    }

    @DeleteMapping("api/quotes/{qid}")
    public Integer deleteQuote(
            @PathVariable("qid") String id) {
        return service.deleteQuote(id);
    }

    @PutMapping("api/quotes/{qid}")
    public Integer updateQuote(
            @PathVariable("qid") String id,
            @RequestBody Quote quote) {
        return service.updateQuote(id, quote);
    }

}
