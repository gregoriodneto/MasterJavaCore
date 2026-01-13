package org.greg.BankSystem.Listeners;

import org.greg.BankSystem.Contracts.EventListener;
import org.greg.BankSystem.Events.DepositEvent;

public class DepositAuditListener implements EventListener<DepositEvent> {
    @Override
    public void onEvent(DepositEvent event) {
        System.out.println("[AUDIT] Depósito realizado | Valor: "+ event.getValue() + " | Data: " + event.occurredAt()+ "\n");
    }
}