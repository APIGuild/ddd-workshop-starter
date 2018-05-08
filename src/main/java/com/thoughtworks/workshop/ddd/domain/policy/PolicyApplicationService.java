package com.thoughtworks.workshop.ddd.domain.policy;

import com.thoughtworks.workshop.ddd.domain.policy.command.BuyPolicyCommand;
import com.thoughtworks.workshop.ddd.domain.policy.command.RenewCommand;
import com.thoughtworks.workshop.ddd.domain.policy.model.Policy;
import com.thoughtworks.workshop.ddd.domain.policy.repository.PolicyRepository;
import com.thoughtworks.workshop.ddd.domain.policy.service.MessageService;
import com.thoughtworks.workshop.ddd.domain.policy.service.PolicyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PolicyApplicationService {

    private PolicyFactory policyFactory;
    private PolicyRepository policyRepository;
    private MessageService messageService;

    @Autowired
    public PolicyApplicationService(PolicyFactory policyFactory,
                                    PolicyRepository policyRepository,
                                    MessageService messageService) {

        this.policyFactory = policyFactory;
        this.policyRepository = policyRepository;
        this.messageService = messageService;
    }

    public String buyPolicy(BuyPolicyCommand command) {
        Policy policy = policyFactory.createPolicy(command);

        policyRepository.save(policy);

        return policy.getPolicyNumber();
    }

    public void renew(RenewCommand renewCommand) {

    }
}
