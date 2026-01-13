package org.greg.BankSystem;

import org.greg.BankSystem.Contracts.AccountPolicy;
import org.greg.BankSystem.Contracts.AccountRepository;
import org.greg.BankSystem.Dispatcher.EventDispatcher;
import org.greg.BankSystem.Entity.Account;
import org.greg.BankSystem.Entity.Client;
import org.greg.BankSystem.Enums.AccountType;
import org.greg.BankSystem.Events.DepositEvent;
import org.greg.BankSystem.Events.WithdrawEvent;
import org.greg.BankSystem.Factories.AccountPolicyFactory;
import org.greg.BankSystem.Listeners.DepositAuditListener;
import org.greg.BankSystem.Listeners.DepositLoggerListener;
import org.greg.BankSystem.Listeners.WithdrawAuditListener;
import org.greg.BankSystem.Listeners.WithdrawLoggerListener;
import org.greg.BankSystem.Repositories.AccountImplementsRepository;
import org.greg.BankSystem.UseCases.TransferMoneyUseCase;

public class Main {
    public static void main(String[] args) {
        caseTest2();
    }

    static void caseTest2() {
        AccountPolicy policy = AccountPolicyFactory.create(AccountType.SIMPLE);
        AccountPolicy policyMiddle = AccountPolicyFactory.create(AccountType.MIDDLE);
        EventDispatcher events = new EventDispatcher();

        AccountRepository accountRepository = new AccountImplementsRepository();

        Client c1 = new Client("José");
        Client c2 = new Client("Maria");

        Account acc1 = new Account(50, c1, policy, events);
        Account acc2 = new Account(50, c2, policyMiddle, events);

        accountRepository.save(acc1);
        accountRepository.save(acc2);

        TransferMoneyUseCase transferMoneyUseCase = new TransferMoneyUseCase(
                accountRepository,
                events
        );

        transferMoneyUseCase.execute(acc1.getId(), acc2.getId(), 20);
        System.out.println(acc1);
        System.out.println(acc2);
    }

    static void caseTest1() {
        AccountPolicy policy = AccountPolicyFactory.create(AccountType.SIMPLE);

        EventDispatcher events = new EventDispatcher();

        DepositLoggerListener depositLoggerListener = new DepositLoggerListener();
        WithdrawLoggerListener withdrawLoggerListener = new WithdrawLoggerListener();

        DepositAuditListener depositAuditListener = new DepositAuditListener();
        WithdrawAuditListener withdrawAuditListener = new WithdrawAuditListener();

        events.register(DepositEvent.class, depositLoggerListener);
        events.register(WithdrawEvent.class, withdrawLoggerListener);

        events.register(DepositEvent.class, depositAuditListener);
        events.register(WithdrawEvent.class, withdrawAuditListener);

        Client c1 = new Client("José");
        Account acc1 = new Account(100, c1, policy, events);
        acc1.deposit(10);
        acc1.withdraw(50);
        acc1.deposit(301);
        acc1.printStatement();
    }
}
