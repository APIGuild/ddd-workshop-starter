package com.thoughtworks.workshop.ddd.webapi.policy;

import com.thoughtworks.workshop.ddd.domain.policy.PolicyApplicationService;
import com.thoughtworks.workshop.ddd.domain.policy.command.BuyPolicyCommand;
import com.thoughtworks.workshop.ddd.domain.policy.command.RenewCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.thoughtworks.workshop.ddd.utils.constant.Constants.CONTENT_TYPE;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "/policy", consumes = CONTENT_TYPE)
@Api(tags = "Policy", description = "Policy Resource", consumes = CONTENT_TYPE)
public class PolicyController {
    @Autowired
    private PolicyApplicationService applicationService;

    @PostMapping
    @ResponseStatus(CREATED)
    @ApiOperation(value = "Buy Policy", notes = "This is for buying policy")
    public String buyPolicy(@Valid @RequestBody BuyPolicyCommand policyDetail) {
        return applicationService.buyPolicy(policyDetail);
    }

    @PutMapping(value = "/{policyNumber}")
    @ResponseStatus(OK)
    @ApiOperation(value = "Renew Policy", notes = "This is for renewAt policy")
    public void renewPolicy(@PathVariable String policyNumber, @RequestBody RenewCommand renewCommand) {
        applicationService.renew(renewCommand);
    }
}
