package com.thoughtworks.workshop.ddd;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class HelloWorldControllerTest {

    @Test
    public void shouldReturnHelloWorldWhenInvokeHelloWorldMethod() {
        HelloWorldController helloWorldController = new HelloWorldController();

        String helloWorld = helloWorldController.helloWorld();

        assertThat(helloWorld, is("Hello World!"));
    }
}