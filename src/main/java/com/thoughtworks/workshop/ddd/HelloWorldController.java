package com.thoughtworks.workshop.ddd;

import static org.springframework.http.HttpStatus.OK;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "Hello World", description = "Hello World")
public class HelloWorldController {
    @GetMapping("/world")
    @ResponseStatus(OK)
    @ApiOperation(value = "Hello World", notes = "This is for hello world")
    public String helloWorld() {
        return "Hello World!";
    }


}
