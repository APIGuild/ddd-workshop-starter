package com.thoughtworks.workshop.ddd.domain.core;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.thoughtworks.workshop.ddd.domain.core.event.DomainEvent;

@Component
public class DomainEventPublisher {

    private static final Logger LOGGER = LoggerFactory.getLogger(DomainEventPublisher.class);

    private List<DomainEventSubscriber> domainEventSubscribers;

    @Autowired
    public DomainEventPublisher(List<DomainEventSubscriber> domainEventSubscribers) {
        this.domainEventSubscribers = domainEventSubscribers;
    }

    public void publish(DomainEvent domainEvent) {
        LOGGER.info("publish domain event: {}", domainEvent);
        domainEventSubscribers.stream()
                .filter(subscriber -> subscriber.subscribedToEvent().isInstance(domainEvent))
                .forEach(subscriber -> subscriber.handle(domainEvent));
    }
}
