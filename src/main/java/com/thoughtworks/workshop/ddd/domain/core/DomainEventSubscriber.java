package com.thoughtworks.workshop.ddd.domain.core;

import com.thoughtworks.workshop.ddd.domain.core.event.DomainEvent;

public interface DomainEventSubscriber<T extends DomainEvent> {

    Class<? super T> subscribedToEvent();

    void handle(T event);
}
