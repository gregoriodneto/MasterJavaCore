package org.greg.BankSystem.Listeners;

import org.greg.BankSystem.Contracts.DomainEvent;

public class TransactionLoggerListener implements EventListener<DomainEvent>{
    @Override
    public void onEvent(DomainEvent event) {
        System.out.println("LOG: "+ event.getName() +" de " + event.getValue());
    }
}
