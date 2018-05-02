package com.thoughtworks.workshop.ddd.domain.quote.service;

import org.springframework.stereotype.Service;
import com.thoughtworks.workshop.ddd.domain.quote.command.GenerateCarPolicyQuoteCommand;
import com.thoughtworks.workshop.ddd.domain.quote.model.CarPolicyQuote;

@Service
public class CarPolicyQuoteService {
    private static final String BRAND_MODEL_FORMAT = "%s %s";

    public CarPolicyQuote generateQuote(GenerateCarPolicyQuoteCommand command) {
        // TODO(You): Workshop-2
        return null;
    }
}
