package com.thoughtworks.workshop.ddd.persistence.quote;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
import com.thoughtworks.workshop.ddd.domain.quote.model.HomePolicyQuote;
import com.thoughtworks.workshop.ddd.domain.quote.repository.HomePolicyQuoteRepository;

@Repository
public class HomePolicyQuoteRepositoryInMemory implements HomePolicyQuoteRepository {
    private Map<String, HomePolicyQuote> homePolicyQuoteMap = new HashMap<>();

    @Override
    public void save(HomePolicyQuote homePolicyQuote) {
        homePolicyQuoteMap.put(homePolicyQuote.getQuoteId(), homePolicyQuote);
    }

    @Override
    public HomePolicyQuote byId(String quoteId) {
        return homePolicyQuoteMap.get(quoteId);
    }
}
