package com.thoughtworks.workshop.ddd.domain.quote.service;

import org.springframework.stereotype.Service;
import com.thoughtworks.workshop.ddd.domain.quote.command.GenerateHomePolicyQuoteCommand;
import com.thoughtworks.workshop.ddd.domain.quote.mapper.HomePolicyQuoteMapper;
import com.thoughtworks.workshop.ddd.domain.quote.model.HomePolicyQuote;

@Service
public class HomePolicyQuoteService extends QuoteService<HomePolicyQuote, GenerateHomePolicyQuoteCommand> {

    @Override
    public HomePolicyQuote generateQuote(GenerateHomePolicyQuoteCommand command) {
        HomePolicyQuote homePolicyQuote = HomePolicyQuoteMapper.INSTANCE.mapToHomePolicyQuote(command);

        homePolicyQuote.setPremium(calculateHomePolicyQuotePremium(command));

        return homePolicyQuote;
    }

    private Double calculateHomePolicyQuotePremium(GenerateHomePolicyQuoteCommand command) {
        Double constructionMaterialRate = retrieveQuoteRate(command.getConstructionMaterial());
        Double buildingTypeRate = retrieveQuoteRate(command.getBuildingType());
        Double bedroomsTypeRate = retrieveQuoteRate(command.getBedroomsType());

        Double premium = multiplyBasePremiumByRates(constructionMaterialRate, buildingTypeRate, bedroomsTypeRate);

        return formatPremium(premium);
    }

}
