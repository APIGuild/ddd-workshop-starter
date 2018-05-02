package com.thoughtworks.workshop.ddd.domain.quote.service;

import org.springframework.stereotype.Service;
import com.thoughtworks.workshop.ddd.domain.quote.command.GenerateHomePolicyQuoteCommand;
import com.thoughtworks.workshop.ddd.domain.quote.model.HomePolicyQuote;

@Service
public class HomePolicyQuoteService {

    public HomePolicyQuote generateQuote(GenerateHomePolicyQuoteCommand command) {
        // TODO(You): Workshop-2
        return null;
    }
}
