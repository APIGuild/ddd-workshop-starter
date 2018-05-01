package com.thoughtworks.workshop.ddd.domain.quote;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.thoughtworks.workshop.ddd.domain.quote.command.GenerateCarPolicyQuoteCommand;
import com.thoughtworks.workshop.ddd.domain.quote.command.GenerateHomePolicyQuoteCommand;
import com.thoughtworks.workshop.ddd.domain.quote.model.CarPolicyQuote;
import com.thoughtworks.workshop.ddd.domain.quote.model.HomePolicyQuote;
import com.thoughtworks.workshop.ddd.domain.quote.repository.CarPolicyQuoteRepository;
import com.thoughtworks.workshop.ddd.domain.quote.repository.HomePolicyQuoteRepository;
import com.thoughtworks.workshop.ddd.domain.quote.service.CarPolicyQuoteService;
import com.thoughtworks.workshop.ddd.domain.quote.service.HomePolicyQuoteService;

@RunWith(MockitoJUnitRunner.class)
public class QuoteApplicationServiceTest {

    @InjectMocks
    private QuoteApplicationService applicationService;

    @Mock
    private HomePolicyQuoteService homePolicyQuoteService;

    @Mock
    private HomePolicyQuoteRepository homePolicyQuoteRepository;

    @Mock
    private CarPolicyQuoteService carPolicyQuoteService;

    @Mock
    private CarPolicyQuoteRepository carPolicyQuoteRepository;

    @Test
    public void shouldGenerateHomePolicyQuoteGivenHomePolicyQuoteCommand() {
        GenerateHomePolicyQuoteCommand homePolicyQuoteCommand = new GenerateHomePolicyQuoteCommand();
        HomePolicyQuote expectedHomePolicyQuote = new HomePolicyQuote();
        when(homePolicyQuoteService.generateQuote(homePolicyQuoteCommand)).thenReturn(expectedHomePolicyQuote);

        HomePolicyQuote homePolicyQuote = applicationService.generateQuote(homePolicyQuoteCommand);

        verify(homePolicyQuoteRepository).save(homePolicyQuote);
        assertThat(expectedHomePolicyQuote, is(expectedHomePolicyQuote));
    }

    @Test
    public void shouldGenerateCarPolicyQuoteGivenCarPolicyQuoteCommand() {
        GenerateCarPolicyQuoteCommand carPolicyQuoteCommand = new GenerateCarPolicyQuoteCommand();
        CarPolicyQuote expectedCarPolicyQuote = new CarPolicyQuote();
        when(carPolicyQuoteService.generateQuote(carPolicyQuoteCommand)).thenReturn(expectedCarPolicyQuote);

        CarPolicyQuote carPolicyQuote = applicationService.generateQuote(carPolicyQuoteCommand);

        verify(carPolicyQuoteRepository).save(carPolicyQuote);
        assertThat(carPolicyQuote, is(expectedCarPolicyQuote));
    }

}