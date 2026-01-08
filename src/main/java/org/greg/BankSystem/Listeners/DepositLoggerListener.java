package org.greg.BankSystem.Listeners;

import org.greg.BankSystem.Contracts.DomainEvent;
import org.greg.BankSystem.Contracts.EventListener;
import org.greg.BankSystem.Enums.TransactionType;
import org.greg.BankSystem.Events.DepositEvent;

public class DepositLoggerListener implements EventListener<DepositEvent> {
    @Override
    public void onEvent(DepositEvent event) {
        System.out.println("LOG: Depósito de " + event.getValue());
    }
}