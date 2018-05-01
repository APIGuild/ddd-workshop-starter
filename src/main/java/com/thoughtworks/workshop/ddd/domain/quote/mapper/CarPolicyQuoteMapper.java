package com.thoughtworks.workshop.ddd.domain.quote.mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;
import static org.mapstruct.factory.Mappers.getMapper;

import org.mapstruct.Mapper;
import com.thoughtworks.workshop.ddd.domain.quote.command.GenerateCarPolicyQuoteCommand;
import com.thoughtworks.workshop.ddd.domain.quote.model.CarPolicyQuote;

@Mapper(unmappedTargetPolicy = IGNORE)
public interface CarPolicyQuoteMapper {
    CarPolicyQuoteMapper INSTANCE = getMapper(CarPolicyQuoteMapper.class);

    CarPolicyQuote mapToCarPolicyQuote(GenerateCarPolicyQuoteCommand generateCarPolicyQuoteCommand);
}
