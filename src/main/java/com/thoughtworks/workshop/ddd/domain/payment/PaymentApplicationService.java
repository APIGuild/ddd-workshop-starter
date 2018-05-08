package com.thoughtworks.workshop.ddd.domain.payment;

import com.thoughtworks.workshop.ddd.domain.policy.model.PolicyRenewedEvent;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
public class PaymentApplicationService {

    public void cutPayment(PolicyRenewedEvent policyRenewedEvent) {
        System.out.println(format("%s %s %s", policyRenewedEvent.getCardNumber(),
                policyRenewedEvent.getPolicyNumber(), policyRenewedEvent.getPremium()));
    }
}
