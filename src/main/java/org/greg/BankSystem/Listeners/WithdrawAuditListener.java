package org.greg.BankSystem.Listeners;

import org.greg.BankSystem.Contracts.EventListener;
import org.greg.BankSystem.Events.WithdrawEvent;

public class WithdrawAuditListener implements EventListener<WithdrawEvent> {
    @Override
    public void onEvent(WithdrawEvent event) {
        System.out.println("[AUDIT] Saque realizado | Valor: "+ event.getValue() + " | Data: " + event.occurredAt()+ "\n");
    }
}
