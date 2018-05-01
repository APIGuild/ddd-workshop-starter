package com.thoughtworks.workshop.ddd.domain.quote.service;

import static java.lang.String.format;

import org.springframework.stereotype.Service;
import com.thoughtworks.workshop.ddd.domain.quote.command.GenerateCarPolicyQuoteCommand;
import com.thoughtworks.workshop.ddd.domain.quote.mapper.CarPolicyQuoteMapper;
import com.thoughtworks.workshop.ddd.domain.quote.model.CarPolicyQuote;

@Service
public class CarPolicyQuoteService extends QuoteService<CarPolicyQuote, GenerateCarPolicyQuoteCommand> {
    private static final String BRAND_MODEL_FORMAT = "%s %s";

    @Override
    public CarPolicyQuote generateQuote(GenerateCarPolicyQuoteCommand command) {
        CarPolicyQuote carPolicyQuote = CarPolicyQuoteMapper.INSTANCE.mapToCarPolicyQuote(command);

        carPolicyQuote.setPremium(calculateCarPolicyQuotePremium(command));

        return carPolicyQuote;
    }

    private Double calculateCarPolicyQuotePremium(GenerateCarPolicyQuoteCommand command) {
        String brandModel = format(BRAND_MODEL_FORMAT, command.getBrand(), command.getModel());
        Double yearOfMakeRate = retrieveQuoteRate(command.getYearOfMake());
        Double brandModelRate = retrieveQuoteRate(brandModel);
        Double parkingAddressRate = retrieveQuoteRate(command.getParkingAddress());
        Double kilosEachYearRate = retrieveQuoteRate(command.getKilosEachYear());

        Double premium = multiplyBasePremiumByRates(yearOfMakeRate, brandModelRate, parkingAddressRate, kilosEachYearRate);

        return formatPremium(premium);
    }
}
