package com.thoughtworks.workshop.ddd.configuration;

import com.thoughtworks.workshop.ddd.domain.payment.PaymentApplicationService;
import com.thoughtworks.workshop.ddd.domain.policy.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
public class MessageConfiguration {

    private final MessageService messageService;
    private final PaymentApplicationService paymentApplicationService;

    @Autowired
    public MessageConfiguration(MessageService messageService,
                                PaymentApplicationService paymentApplicationService) {

        this.messageService = messageService;
        this.paymentApplicationService = paymentApplicationService;
    }

    @Scheduled(fixedDelay = 5000)
    public void processMessages() {
        messageService.retrieveExistingEvent()
                .forEach(paymentApplicationService::cutPayment);
    }
}
