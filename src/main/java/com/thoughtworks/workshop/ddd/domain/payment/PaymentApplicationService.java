package com.thoughtworks.workshop.ddd.domain.payment;

import static java.lang.String.format;

import org.springframework.stereotype.Service;

@Service
public class PaymentApplicationService {

    public void cutPayment(String policyNumber, String cardNumber, Double premium) {
        System.out.println("============Received Policy Renewed Event================");
        System.out.println("Policy Number      Card Number        Premium==============");
        System.out.println(format("%s            %s             %s", policyNumber, cardNumber, premium));
        System.out.println("=========================================================");
    }
}
