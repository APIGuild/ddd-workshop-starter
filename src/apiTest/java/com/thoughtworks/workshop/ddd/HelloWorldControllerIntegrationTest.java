package com.thoughtworks.workshop.ddd;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;

public class HelloWorldControllerIntegrationTest extends BaseIntegrationTest {
    @Test
    public void shouldSayHelloWorldWhenRequestHelloWorldEndpoint() throws Exception {
        performRequest(get("/world"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("Hello World!"));
    }
}