package com.thoughtworks.workshop.ddd.domain.quote;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.thoughtworks.workshop.ddd.domain.quote.command.GenerateCarPolicyQuoteCommand;
import com.thoughtworks.workshop.ddd.domain.quote.command.GenerateHomePolicyQuoteCommand;
import com.thoughtworks.workshop.ddd.domain.quote.model.CarPolicyQuote;
import com.thoughtworks.workshop.ddd.domain.quote.model.HomePolicyQuote;

@Service
@Transactional
public class QuoteApplicationService {

    public HomePolicyQuote generateQuote(GenerateHomePolicyQuoteCommand command) {
        // TODO(You): Workshop-2
        return null;
    }

    public CarPolicyQuote generateQuote(GenerateCarPolicyQuoteCommand command) {
        // TODO(You): Workshop-2
        return null;
    }
}
