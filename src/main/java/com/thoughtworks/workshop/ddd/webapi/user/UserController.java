package com.thoughtworks.workshop.ddd.webapi.user;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.thoughtworks.workshop.ddd.domain.user.UserApplicationService;
import com.thoughtworks.workshop.ddd.domain.user.command.InitPasswordCommand;
import com.thoughtworks.workshop.ddd.domain.user.command.LoginCommand;
import com.thoughtworks.workshop.ddd.domain.user.command.RegisterCommand;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
@Api(value = "User REST API", description = "User related API")
public class UserController {

    @Autowired
    private UserApplicationService userApplicationService;

    @CrossOrigin
    @PostMapping
    @ResponseStatus(CREATED)
    @ApiOperation(value = "Register User", notes = "Registration")
    public String register(@RequestBody @Valid RegisterCommand command) {
        return userApplicationService.register(command);
    }

    @CrossOrigin
    @PutMapping(value = "/password")
    @ResponseStatus(OK)
    @ApiOperation(value = "User Login", notes = "Set password")
    public void initPassword(@RequestBody @Valid InitPasswordCommand command) {
        userApplicationService.initPassword(command);
    }

    @CrossOrigin
    @PostMapping(value = "/login")
    @ResponseStatus(OK)
    @ApiOperation(value = "Init Password", notes = "Login")
    public void login(@RequestBody @Valid LoginCommand command) {
        userApplicationService.login(command);
    }
}
