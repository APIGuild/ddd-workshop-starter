package com.thoughtworks.workshop.ddd.webapi.user;

import com.thoughtworks.workshop.ddd.user.UserApplicationService;
import com.thoughtworks.workshop.ddd.user.command.InitPasswordCommand;
import com.thoughtworks.workshop.ddd.user.command.LoginCommand;
import com.thoughtworks.workshop.ddd.user.command.RegisterCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/user")
@Api(value = "User REST API", description = "User related API")
public class UserController {

    @Autowired
    private UserApplicationService userApplicationService;

    @CrossOrigin
    @PostMapping
    @ResponseStatus(CREATED)
    @ApiOperation(value = "POST", notes = "Registration")
    public String register(@RequestBody @Valid RegisterCommand command) {
        return userApplicationService.register(command);
    }

    @CrossOrigin
    @PutMapping(value = "/password")
    @ResponseStatus(OK)
    @ApiOperation(value = "PUT", notes = "Set password")
    public void initPassword(@RequestBody @Valid InitPasswordCommand command) {
        userApplicationService.initPassword(command);
    }

    @CrossOrigin
    @PostMapping(value = "/login")
    @ResponseStatus(OK)
    @ApiOperation(value = "POST", notes = "Login")
    public void login(@RequestBody @Valid LoginCommand command) {
        userApplicationService.login(command);
    }
}
