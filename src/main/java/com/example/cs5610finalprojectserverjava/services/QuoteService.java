package com.example.cs5610finalprojectserverjava.services;

import com.example.cs5610finalprojectserverjava.models.Quote;
import com.example.cs5610finalprojectserverjava.repositories.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuoteService {

    @Autowired
    QuoteRepository repository;

    public List<Quote> findAllQuotes() {
        return (List<Quote>) repository.findAll();
    }

    public Quote findQuoteById(Long id) {
        return repository.findById(id).get();
    }

    public Quote createQuote(Quote quote) {
        return repository.save(quote);
    }

    public Integer deleteQuote(Long id) {
        repository.deleteById(id);
        return 1;
    }

    public Integer updateQuote(Long id, Quote quote) {
        if (repository.findById(id).isPresent()) {
            Quote originalQuote = repository.findById(id).get();

//            if (quote.getQuoteText() != null) {
//                originalQuote.setQuoteText(quote.getQuoteText());
//            }
//
//            if (quote.getApiId() != null) {
//                originalQuote.setApiId(quote.getApiId());
//            }

            repository.save(originalQuote);
        }
        return 1;
    }
}
