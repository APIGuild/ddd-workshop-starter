package com.thoughtworks.workshop.ddd.domain.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.thoughtworks.workshop.ddd.domain.core.DomainEventSubscriber;
import com.thoughtworks.workshop.ddd.domain.core.event.PolicyRenewedEvent;

@Component
public class PolicyPaymentSubscriber implements DomainEventSubscriber<PolicyRenewedEvent> {
    private PaymentApplicationService paymentApplicationService;

    @Autowired
    public PolicyPaymentSubscriber(PaymentApplicationService paymentApplicationService) {
        this.paymentApplicationService = paymentApplicationService;
    }

    @Override
    public Class<PolicyRenewedEvent> subscribedToEvent() {
        return PolicyRenewedEvent.class;
    }

    @Override
    public void handle(PolicyRenewedEvent event) {
        paymentApplicationService.cutPayment(event.getPolicyNumber(), event.getCardNumber(), event.getPremium());
    }
}
