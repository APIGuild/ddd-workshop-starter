package com.thoughtworks.workshop.ddd.domain.quote.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CarPolicyQuote extends PolicyQuote {
    private String yearOfMake;
    private String brand;
    private String model;
    private String parkingAddress;
    private String kilosEachYear;
    private DriverDetail driverDetail;
}
