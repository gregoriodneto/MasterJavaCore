package org.greg.BankSystem.Events;

import org.greg.BankSystem.Contracts.DomainEvent;
import org.greg.BankSystem.Enums.TransactionType;

import java.util.Date;

public class DepositEvent implements DomainEvent {
    private final double value;
    private final Date occurredAt;

    public DepositEvent(double value) {
        this.value = value;
        this.occurredAt = new Date();
    }

    @Override
    public String getName() {
        return TransactionType.DEPOSIT.name();
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public Date occurredAt() {
        return occurredAt;
    }
}
