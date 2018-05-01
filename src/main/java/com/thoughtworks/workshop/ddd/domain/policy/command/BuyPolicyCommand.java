package com.thoughtworks.workshop.ddd.domain.policy.command;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import com.thoughtworks.workshop.ddd.domain.policy.model.HolderDetail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BuyPolicyCommand {
    @NotBlank
    private String policyStartDate;
    @NotBlank
    private String quoteId;
    @Valid
    private HolderDetail holderDetail;
}
