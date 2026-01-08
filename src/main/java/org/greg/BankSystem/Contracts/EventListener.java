package org.greg.BankSystem.Contracts;

public interface EventListener<T extends DomainEvent> {
    void onEvent(T event);
}