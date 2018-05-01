package com.thoughtworks.workshop.ddd.domain.quote.mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;
import static org.mapstruct.factory.Mappers.getMapper;

import org.mapstruct.Mapper;
import com.thoughtworks.workshop.ddd.domain.quote.command.GenerateHomePolicyQuoteCommand;
import com.thoughtworks.workshop.ddd.domain.quote.model.HomePolicyQuote;

@Mapper(unmappedTargetPolicy = IGNORE)
public interface HomePolicyQuoteMapper {
    HomePolicyQuoteMapper INSTANCE = getMapper(HomePolicyQuoteMapper.class);

    HomePolicyQuote mapToHomePolicyQuote(GenerateHomePolicyQuoteCommand generateHomePolicyQuoteCommand);
}
