package org.greg.BankSystem.Contracts;

import java.util.Date;

public interface DomainEvent {
    String getName();
    double getValue();
    Date occurredAt();
}
