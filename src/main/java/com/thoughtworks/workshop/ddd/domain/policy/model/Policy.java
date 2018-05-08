package com.thoughtworks.workshop.ddd.domain.policy.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

import static java.time.LocalDate.now;

@Setter
@Getter
public class Policy {
    public static final long TWO_YEARS = 2L;
    private String policyNumber = UUID.randomUUID().toString();
    private LocalDate policyStartDate;
    private LocalDate policyEndDate;
    private String quoteId;
    private HolderDetail holderDetail;

    public Policy() {
        setPolicyStartDate(now());
    }

    private void setPolicyStartDate(LocalDate policyStartDate) {
        this.policyStartDate = policyStartDate;
        this.policyEndDate = policyStartDate.plusYears(TWO_YEARS);
    }
}
