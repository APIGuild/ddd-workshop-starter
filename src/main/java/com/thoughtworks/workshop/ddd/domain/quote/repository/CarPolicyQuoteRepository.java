package com.thoughtworks.workshop.ddd.domain.quote.repository;


import com.thoughtworks.workshop.ddd.domain.quote.model.CarPolicyQuote;

public interface CarPolicyQuoteRepository {
    void save(CarPolicyQuote carPolicyQuote);

    CarPolicyQuote byId(String quoteId);
}
