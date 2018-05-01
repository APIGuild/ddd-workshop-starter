package com.thoughtworks.workshop.ddd.domain.policy.mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;
import static org.mapstruct.factory.Mappers.getMapper;

import org.mapstruct.Mapper;
import com.thoughtworks.workshop.ddd.domain.policy.command.BuyPolicyCommand;
import com.thoughtworks.workshop.ddd.domain.policy.model.Policy;

@Mapper(unmappedTargetPolicy = IGNORE)
public interface PolicyMapper {
    PolicyMapper INSTANCE = getMapper(PolicyMapper.class);

    Policy mapToPolicy(BuyPolicyCommand CarPolicy);
}
