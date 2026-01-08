package org.greg.BankSystem.Listeners;

import org.greg.BankSystem.Contracts.EventListener;
import org.greg.BankSystem.Enums.TransactionType;
import org.greg.BankSystem.Events.WithdrawEvent;

public class WithdrawLoggerListener implements EventListener<WithdrawEvent> {
    @Override
    public void onEvent(WithdrawEvent event) {
        System.out.println("LOG: Saque de " + event.getValue());
    }
}
