package com.thoughtworks.workshop.ddd.user.command;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ApiModel(description = "User reset password request model")
public class InitPasswordCommand {

    @NotBlank(message = "uuid can not be empty")
    @ApiModelProperty(value = "Uuid", example = "123")
    private String uuid;

    @NotBlank(message = "password can not be empty")
    @ApiModelProperty(value = "Password", example = "123")
    private String password;
}
