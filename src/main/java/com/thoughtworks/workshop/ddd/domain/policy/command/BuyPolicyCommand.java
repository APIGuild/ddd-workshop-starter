package com.thoughtworks.workshop.ddd.domain.policy.command;

import com.thoughtworks.workshop.ddd.domain.policy.model.HolderDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BuyPolicyCommand {
    @NotBlank
    private String quoteId;
    @Valid
    private HolderDetail holderDetail;
}
