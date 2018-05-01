package com.thoughtworks.workshop.ddd.domain.quote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.thoughtworks.workshop.ddd.domain.quote.command.GenerateCarPolicyQuoteCommand;
import com.thoughtworks.workshop.ddd.domain.quote.command.GenerateHomePolicyQuoteCommand;
import com.thoughtworks.workshop.ddd.domain.quote.model.CarPolicyQuote;
import com.thoughtworks.workshop.ddd.domain.quote.model.HomePolicyQuote;
import com.thoughtworks.workshop.ddd.domain.quote.repository.CarPolicyQuoteRepository;
import com.thoughtworks.workshop.ddd.domain.quote.repository.HomePolicyQuoteRepository;
import com.thoughtworks.workshop.ddd.domain.quote.service.CarPolicyQuoteService;
import com.thoughtworks.workshop.ddd.domain.quote.service.HomePolicyQuoteService;

@Service
@Transactional
public class QuoteApplicationService {

    @Autowired
    private CarPolicyQuoteService carPolicyQuoteService;

    @Autowired
    private HomePolicyQuoteService homePolicyQuoteService;

    @Autowired
    private CarPolicyQuoteRepository carPolicyQuoteRepository;

    @Autowired
    private HomePolicyQuoteRepository homePolicyQuoteRepository;

    public HomePolicyQuote generateQuote(GenerateHomePolicyQuoteCommand command) {
        HomePolicyQuote homePolicyQuote = homePolicyQuoteService.generateQuote(command);

        homePolicyQuoteRepository.save(homePolicyQuote);

        return homePolicyQuote;
    }

    public CarPolicyQuote generateQuote(GenerateCarPolicyQuoteCommand command) {
        CarPolicyQuote carPolicyQuote = carPolicyQuoteService.generateQuote(command);

        carPolicyQuoteRepository.save(carPolicyQuote);

        return carPolicyQuote;
    }
}
