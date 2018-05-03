package com.thoughtworks.workshop.ddd.domain.quote.service;

import static java.lang.String.format;
import static java.util.Optional.ofNullable;
import static java.util.stream.Stream.of;

import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Autowired;
import com.thoughtworks.workshop.ddd.domain.quote.repository.QuoteRateRepository;
import com.thoughtworks.workshop.ddd.exception.BadRequestException;

public abstract class QuoteService<R, C> {
    private static final Double BASE_PREMIUM = 100.0;
    private static final String NUMBER_PATTERN = "#.00";
    private static final String INVALID_POLICY_QUOTE_CATEGORY_MESSAGE = "Invalid policy quote category: '%s'. Failed to calculate the quote!";

    @Autowired
    private QuoteRateRepository quoteRateRepository;

    public abstract R generateQuote(C command);

    protected Double retrieveQuoteRate(String category) {
        return ofNullable(quoteRateRepository.getRate(category))
                .orElseThrow(() -> new BadRequestException(format(INVALID_POLICY_QUOTE_CATEGORY_MESSAGE, category)));
    }

    protected Double multiplyBasePremiumByRates(Double... rates) {
        return of(rates).reduce(BASE_PREMIUM, (current, next) -> current * next);
    }

    protected Double formatPremium(Double premium) {
        DecimalFormat decimalFormat = new DecimalFormat(NUMBER_PATTERN);
        return new Double(decimalFormat.format(premium));
    }
}
