package com.thoughtworks.workshop.ddd.domain.policy.service;

import com.thoughtworks.workshop.ddd.domain.policy.model.PolicyRenewedEvent;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    private List<PolicyRenewedEvent> events = new ArrayList<>();

    public synchronized void publish(PolicyRenewedEvent policyRenewedEvent) {
        events.add(policyRenewedEvent);
    }

    public synchronized List<PolicyRenewedEvent> retrieveExistingEvent() {
        List<PolicyRenewedEvent> temps = events;
        events = new ArrayList<>();
        return temps;
    }
}
