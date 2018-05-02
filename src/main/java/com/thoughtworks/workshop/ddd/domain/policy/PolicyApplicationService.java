package com.thoughtworks.workshop.ddd.domain.policy;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.thoughtworks.workshop.ddd.domain.policy.command.BuyPolicyCommand;

@Service
@Transactional
public class PolicyApplicationService {

    public String buyPolicy(BuyPolicyCommand command) {
        // TODO(You): Workshop-2
        return null;
    }
}
