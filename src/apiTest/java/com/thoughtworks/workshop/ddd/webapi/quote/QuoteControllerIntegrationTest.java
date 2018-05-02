package com.thoughtworks.workshop.ddd.webapi.quote;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Ignore;
import org.junit.Test;
import com.thoughtworks.workshop.ddd.BaseIntegrationTest;

public class QuoteControllerIntegrationTest extends BaseIntegrationTest {
    @Test
    @Ignore // TODO(You): Workshop-2
    public void shouldGenerateHomePolicyQuoteSuccessfully() throws Exception {
        performRequest(post("/quote/home").content(loadPayload("quote", "home-details.json")))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.quoteId").isNotEmpty())
                .andExpect(jsonPath("$.premium").value(171.6));
    }

    @Test
    @Ignore // TODO(You): Workshop-2
    public void shouldGenerateHomePolicyQuoteThrowBadRequestException() throws Exception {
        performRequest(post("/quote/home").content("{}"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors[0].status").value("400"))
                .andExpect(jsonPath("$.errors[0].title").value("Bad Request"))
                .andExpect(jsonPath("$.errors[0].detail").value("Invalid policy quote category: 'null'. Failed to calculate the quote!"));
    }

    @Test
    @Ignore // TODO(You): Workshop-2
    public void shouldGenerateCarPolicyQuoteSuccessfully() throws Exception {
        performRequest(post("/quote/car").content(loadPayload("quote", "car-details.json")))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.quoteId").isNotEmpty())
                .andExpect(jsonPath("$.premium").value(368.64));
    }

    @Test
    @Ignore // TODO(You): Workshop-2
    public void shouldGenerateCarPolicyQuoteThrowBadRequestException() throws Exception {
        performRequest(post("/quote/car").content("{}"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors[0].status").value("400"))
                .andExpect(jsonPath("$.errors[0].title").value("Bad Request"))
                .andExpect(jsonPath("$.errors[0].detail").value("Invalid policy quote category: 'null'. Failed to calculate the quote!"));
    }
}