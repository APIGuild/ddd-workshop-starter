package com.thoughtworks.workshop.ddd.domain.payment;

import org.springframework.stereotype.Component;
import com.thoughtworks.workshop.ddd.domain.core.DomainEventSubscriber;
import com.thoughtworks.workshop.ddd.domain.core.event.PolicyRenewedEvent;

@Component
public class PaymentSubscriber implements DomainEventSubscriber<PolicyRenewedEvent> {

    @Override
    public Class<PolicyRenewedEvent> subscribedToEvent() {
        return PolicyRenewedEvent.class;
    }

    @Override
    public void handle(PolicyRenewedEvent event) {
        // TODO(who): invoke payment application service
    }
}
