package com.thoughtworks.workshop.ddd.domain.quote.repository;

public interface QuoteRateRepository {
    Double getRate(String category);
}
