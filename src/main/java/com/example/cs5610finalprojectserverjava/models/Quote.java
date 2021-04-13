package com.example.cs5610finalprojectserverjava.models;

import javax.persistence.*;

@Entity
@Table(name="quotes")
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String quoteText;
    // pulled from api so it can be used to direct to /details/quote/apiId
    private String apiId;


    public Quote(Long id, String quoteText, String apiId) {
        this.id = id;
        this.quoteText = quoteText;
        this.apiId = apiId;
    }
    public Quote() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuoteText() {
        return quoteText;
    }

    public void setQuoteText(String quoteText) {
        this.quoteText = quoteText;
    }

    public String getApiId() {
        return apiId;
    }

    public void setApiId(String apiId) {
        this.apiId = apiId;
    }
}
