package com.thoughtworks.workshop.ddd.domain.policy.command;

public class RenewCommand {
    private String policyNumber;
    private String cardNumber;
    private double premium;

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getPremium() {
       return this.premium;
    }
}