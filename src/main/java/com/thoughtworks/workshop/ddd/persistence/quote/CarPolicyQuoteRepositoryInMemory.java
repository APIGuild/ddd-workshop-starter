package com.thoughtworks.workshop.ddd.persistence.quote;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
import com.thoughtworks.workshop.ddd.domain.quote.model.CarPolicyQuote;
import com.thoughtworks.workshop.ddd.domain.quote.repository.CarPolicyQuoteRepository;

@Repository
public class CarPolicyQuoteRepositoryInMemory implements CarPolicyQuoteRepository {
    private Map<String, CarPolicyQuote> carPolicyQuoteMap = new HashMap<>();

    @Override
    public void save(CarPolicyQuote carPolicyQuote) {
        carPolicyQuoteMap.put(carPolicyQuote.getQuoteId(), carPolicyQuote);
    }

    @Override
    public CarPolicyQuote byId(String quoteId) {
        return carPolicyQuoteMap.get(quoteId);
    }
}
