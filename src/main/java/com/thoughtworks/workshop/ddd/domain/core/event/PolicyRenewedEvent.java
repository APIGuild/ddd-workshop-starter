package com.thoughtworks.workshop.ddd.domain.core.event;

public class PolicyRenewedEvent implements DomainEvent {
    private final String policyNumber;
    private final String cardNumber;
    private final Double premium;


    public PolicyRenewedEvent(String policyNumber, String cardNumber, Double premium) {
        this.policyNumber = policyNumber;
        this.cardNumber = cardNumber;
        this.premium = premium;
    }


    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public Double getPremium() {
        return premium;
    }

    @Override
    public String toString() {
        return "PolicyRenewedEvent{" +
                "policyNumber='" + policyNumber + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", premium=" + premium +
                '}';
    }
}
