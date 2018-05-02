package com.thoughtworks.workshop.ddd.domain.policy.service;

import org.springframework.stereotype.Service;
import com.thoughtworks.workshop.ddd.domain.policy.command.BuyPolicyCommand;
import com.thoughtworks.workshop.ddd.domain.policy.model.Policy;

@Service
public class PolicyFactory {
    private static final String QUOTE_NOT_EXIST_MESSAGE = "Quote <%s> does not exist!";
    private static final String POLICY_EXIST_MESSAGE = "Policy <%s> with quote <%s> already exist!";

    public Policy createPolicy(BuyPolicyCommand command) {
        // TODO(You): Workshop-2
        return null;
    }
}
