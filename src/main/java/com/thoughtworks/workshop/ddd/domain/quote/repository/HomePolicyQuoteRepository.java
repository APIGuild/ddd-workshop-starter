package com.thoughtworks.workshop.ddd.domain.quote.repository;


import com.thoughtworks.workshop.ddd.domain.quote.model.HomePolicyQuote;

public interface HomePolicyQuoteRepository {
    void save(HomePolicyQuote homePolicyQuote);

    HomePolicyQuote byId(String quoteId);
}
