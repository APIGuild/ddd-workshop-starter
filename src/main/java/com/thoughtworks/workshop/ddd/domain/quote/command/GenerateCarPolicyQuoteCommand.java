package com.thoughtworks.workshop.ddd.domain.quote.command;


import com.thoughtworks.workshop.ddd.domain.quote.model.DriverDetail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GenerateCarPolicyQuoteCommand {
    private String yearOfMake;
    private String brand;
    private String model;
    private String parkingAddress;
    private String kilosEachYear;
    private DriverDetail driverDetail;
}
