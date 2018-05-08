package com.thoughtworks.workshop.ddd.persistence.policy;

import com.thoughtworks.workshop.ddd.domain.policy.model.Policy;
import com.thoughtworks.workshop.ddd.domain.policy.repository.PolicyRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PolicyRepositoryInMemory implements PolicyRepository {
    private Map<String, Policy> policies = new HashMap<>();

    @Override
    public void save(Policy policy) {
        policies.put(policy.getPolicyNumber(), policy);
    }

    @Override
    public Policy byPolicyNumber(String policyNumber) {
        return policies.get(policyNumber);
    }

    @Override
    public Policy byQuoteId(String quoteId) {
        return policies.values().stream()
                .filter(policy -> quoteId.equals(policy.getQuoteId()))
                .findFirst()
                .orElse(null);
    }
}
