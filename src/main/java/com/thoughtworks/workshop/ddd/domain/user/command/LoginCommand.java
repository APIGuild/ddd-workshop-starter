package com.thoughtworks.workshop.ddd.domain.user.command;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "User login request model")
public class LoginCommand {

    @NotBlank(message = "email can not be empty")
    @ApiModelProperty(value = "Email", example = "email1")
    private String email;

    @NotBlank(message = "password can not be empty")
    @ApiModelProperty(value = "password", example = "password1")
    private String password;
}
