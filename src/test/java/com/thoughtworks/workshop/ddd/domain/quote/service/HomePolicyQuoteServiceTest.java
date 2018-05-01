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
import com.thoughtworks.workshop.ddd.domain.quote.command.GenerateHomePolicyQuoteCommand;
import com.thoughtworks.workshop.ddd.domain.quote.model.HomePolicyQuote;
import com.thoughtworks.workshop.ddd.domain.quote.repository.QuoteRateRepository;
import com.thoughtworks.workshop.ddd.exception.BadRequestException;

@RunWith(MockitoJUnitRunner.class)
public class HomePolicyQuoteServiceTest {

    @InjectMocks
    private HomePolicyQuoteService homePolicyQuoteService;

    @Mock
    private QuoteRateRepository quoteRateRepository;

    @Before
    public void setUp() {
        when(quoteRateRepository.getRate("钢材")).thenReturn(1.2);
        when(quoteRateRepository.getRate("公寓")).thenReturn(1.1);
        when(quoteRateRepository.getRate("三室及以上")).thenReturn(1.3);
        when(quoteRateRepository.getRate("UNKNOWN")).thenReturn(null);
    }

    @Test
    public void shouldGenerateHomePolicyQuoteGivenHomePolicyCommand() {
        GenerateHomePolicyQuoteCommand command = new GenerateHomePolicyQuoteCommand("钢材", "公寓", "三室及以上", "Address");

        HomePolicyQuote homePolicyQuote = homePolicyQuoteService.generateQuote(command);

        assertThat(homePolicyQuote.getQuoteId(), is(notNullValue()));
        assertThat(homePolicyQuote.getPremium(), is(171.6));
        assertThat(homePolicyQuote.getConstructionMaterial(), is(command.getConstructionMaterial()));
        assertThat(homePolicyQuote.getBuildingType(), is(command.getBuildingType()));
        assertThat(homePolicyQuote.getBedroomsType(), is(command.getBedroomsType()));
        assertThat(homePolicyQuote.getAddress(), is(command.getAddress()));
    }

    @Test(expected = BadRequestException.class)
    public void shouldGenerateHomePolicyQuoteThrowsExceptionGivenHomeQuoteCommandDetailsAsUnknown() {
        GenerateHomePolicyQuoteCommand command = new GenerateHomePolicyQuoteCommand("UNKNOWN", "UNKNOWN", "UNKNOWN", null);

        homePolicyQuoteService.generateQuote(command);
    }
}