package org.greg.BankSystem.Events;

import org.greg.BankSystem.Contracts.DomainEvent;

import java.util.Date;

public class TransferCompletedEvent implements DomainEvent {
    private final String fromAccountId;
    private final String toAccountId;
    private final double amount;

    public TransferCompletedEvent(String fromAccountId, String toAccountId, double amount) {
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.amount = amount;
    }

    @Override
    public Date occurredAt() {
        return new Date();
    }
}
