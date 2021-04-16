package com.example.cs5610finalprojectserverjava.models;

import javax.persistence.*;

@Entity
@Table(name="quotes")
public class Quote {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    // formerly apiId
    @Id
    private String id;

    private String quoteText;
    // pulled from api so it can be used to direct to /details/quote/apiId




    public Quote(String id) {
        this.id = id;
        //this.quoteText = quoteText;
//        this.apiId = apiId;
    }
    public Quote() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    public String getQuoteText() {
//        return quoteText;
//    }
//
//    public void setQuoteText(String quoteText) {
//        this.quoteText = quoteText;
//    }

//    public String getApiId() {
//        return apiId;
//    }
//
//    public void setApiId(String apiId) {
//        this.apiId = apiId;
//    }
}
