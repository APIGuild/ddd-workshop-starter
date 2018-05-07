package com.thoughtworks.workshop.ddd.domain.policy;

import com.thoughtworks.workshop.ddd.domain.policy.command.RenewCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.thoughtworks.workshop.ddd.domain.policy.command.BuyPolicyCommand;
import com.thoughtworks.workshop.ddd.domain.policy.model.Policy;
import com.thoughtworks.workshop.ddd.domain.policy.repository.PolicyRepository;
import com.thoughtworks.workshop.ddd.domain.policy.service.PolicyFactory;

@Service
@Transactional
public class PolicyApplicationService {
    @Autowired
    private PolicyFactory policyFactory;

    @Autowired
    private PolicyRepository policyRepository;

    public String buyPolicy(BuyPolicyCommand command) {
        Policy policy = policyFactory.createPolicy(command);

        policyRepository.save(policy);

        return policy.getPolicyNumber();
    }

    public void renew(RenewCommand renewCommand) {

    }
}
