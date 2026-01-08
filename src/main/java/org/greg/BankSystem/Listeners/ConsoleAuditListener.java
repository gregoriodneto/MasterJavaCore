package org.greg.BankSystem.Listeners;

import org.greg.BankSystem.Contracts.DomainEvent;

public class ConsoleAuditListener implements EventListener<DomainEvent> {
    @Override
    public void onEvent(DomainEvent event) {
        System.out.println("[AUDIT] "+ event.getName() +" realizado | Valor: "+ event.getValue() + " | Data: " + event.occurredAt()+ "\n");
    }
}
