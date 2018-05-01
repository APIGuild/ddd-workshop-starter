package com.thoughtworks.workshop.ddd.domain.quote.service;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.thoughtworks.workshop.ddd.domain.quote.command.GenerateCarPolicyQuoteCommand;
import com.thoughtworks.workshop.ddd.domain.quote.model.CarPolicyQuote;
import com.thoughtworks.workshop.ddd.domain.quote.repository.QuoteRateRepository;
import com.thoughtworks.workshop.ddd.exception.BadRequestException;

@RunWith(MockitoJUnitRunner.class)
public class CarPolicyQuoteServiceTest {
    @InjectMocks
    private CarPolicyQuoteService carPolicyQuoteService;

    @Mock
    private QuoteRateRepository quoteRateRepository;

    @Before
    public void setUp() {
        when(quoteRateRepository.getRate("2010-2014")).thenReturn(1.2);
        when(quoteRateRepository.getRate("BMW C650")).thenReturn(1.6);
        when(quoteRateRepository.getRate("Street")).thenReturn(1.6);
        when(quoteRateRepository.getRate("750-1499km")).thenReturn(1.2);
        when(quoteRateRepository.getRate("UNKNOWN")).thenReturn(null);
    }

    @Test
    public void shouldCalculateQuoteGivenCarDetailsInformation() {
        GenerateCarPolicyQuoteCommand command = new GenerateCarPolicyQuoteCommand("2010-2014", "BMW", "C650", "Street", "750-1499km", null);

        CarPolicyQuote carPolicyQuote = carPolicyQuoteService.generateQuote(command);

        assertThat(carPolicyQuote.getQuoteId(), is(notNullValue()));
        assertThat(carPolicyQuote.getPremium(), is(368.64));
        assertThat(carPolicyQuote.getYearOfMake(), is(command.getYearOfMake()));
        assertThat(carPolicyQuote.getBrand(), is(command.getBrand()));
        assertThat(carPolicyQuote.getModel(), is(command.getModel()));
        assertThat(carPolicyQuote.getParkingAddress(), is(command.getParkingAddress()));
        assertThat(carPolicyQuote.getKilosEachYear(), is(command.getKilosEachYear()));
    }

    @Test(expected = BadRequestException.class)
    public void shouldGenerateCarPolicyQuoteThrowsExceptionGivenCarQuoteCommandDetailsAsUnknown() {
        GenerateCarPolicyQuoteCommand command = new GenerateCarPolicyQuoteCommand("2010-2014", "BMW", "C650", "UNKNOWN", "UNKNOWN", null);

        carPolicyQuoteService.generateQuote(command);
    }
}