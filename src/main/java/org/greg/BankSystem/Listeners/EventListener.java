package org.greg.BankSystem.Listeners;

import org.greg.BankSystem.Contracts.DomainEvent;

public interface EventListener<T extends DomainEvent> {
    void onEvent(T event);
}
