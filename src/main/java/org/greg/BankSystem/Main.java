package org.greg.BankSystem;

import org.greg.BankSystem.Contracts.AccountPolicy;
import org.greg.BankSystem.Contracts.DomainEvent;
import org.greg.BankSystem.Dispatcher.EventDispatcher;
import org.greg.BankSystem.Entity.Account;
import org.greg.BankSystem.Entity.Client;
import org.greg.BankSystem.Enums.AccountType;
import org.greg.BankSystem.Events.DepositEvent;
import org.greg.BankSystem.Events.WithdrawEvent;
import org.greg.BankSystem.Factories.AccountPolicyFactory;
import org.greg.BankSystem.Listeners.ConsoleAuditListener;
import org.greg.BankSystem.Listeners.EventListener;
import org.greg.BankSystem.Listeners.TransactionLoggerListener;

public class Main {
    public static void main(String[] args) {
        AccountPolicy policy = AccountPolicyFactory.create(AccountType.SIMPLE);
        EventDispatcher events = new EventDispatcher();
        TransactionLoggerListener transactionLoggerListener = new TransactionLoggerListener();
        ConsoleAuditListener consoleAuditListener = new ConsoleAuditListener();

        events.register(DepositEvent.class, transactionLoggerListener);
        events.register(WithdrawEvent.class, transactionLoggerListener);

        events.register(DepositEvent.class, consoleAuditListener);
        events.register(WithdrawEvent.class, consoleAuditListener);

        Client c1 = new Client("José");
        Account acc1 = new Account(100, c1, policy, events);
        acc1.deposit(10);
        acc1.withdraw(50);
        acc1.deposit(301);
        acc1.printStatement();
    }
}
