package com.thoughtworks.workshop.ddd.domain.policy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.thoughtworks.workshop.ddd.domain.core.DomainEventPublisher;
import com.thoughtworks.workshop.ddd.domain.core.event.PolicyRenewedEvent;
import com.thoughtworks.workshop.ddd.domain.policy.command.BuyPolicyCommand;
import com.thoughtworks.workshop.ddd.domain.policy.command.RenewCommand;
import com.thoughtworks.workshop.ddd.domain.policy.model.Policy;
import com.thoughtworks.workshop.ddd.domain.policy.repository.PolicyRepository;
import com.thoughtworks.workshop.ddd.domain.policy.service.PolicyFactory;

@Service
@Transactional
public class PolicyApplicationService {

    private PolicyFactory policyFactory;
    private PolicyRepository policyRepository;
    private DomainEventPublisher domainEventPublisher;

    @Autowired
    public PolicyApplicationService(PolicyFactory policyFactory,
                                    PolicyRepository policyRepository,
                                    DomainEventPublisher domainEventPublisher) {

        this.policyFactory = policyFactory;
        this.policyRepository = policyRepository;
        this.domainEventPublisher = domainEventPublisher;
    }

    public String buyPolicy(BuyPolicyCommand command) {
        Policy policy = policyFactory.createPolicy(command);

        policyRepository.save(policy);

        return policy.getPolicyNumber();
    }

    public void renew(RenewCommand renewCommand) {
        // TODO(who) check policy and premium

        PolicyRenewedEvent domainEvent =
                new PolicyRenewedEvent(renewCommand.getPolicyNumber(), renewCommand.getCardNumber(), renewCommand.getPrice());
        domainEventPublisher.publish(domainEvent);
    }
}
