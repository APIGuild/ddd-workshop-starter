package com.thoughtworks.workshop.ddd.domain.policy.model;

public class PolicyRenewedEvent {
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
}
