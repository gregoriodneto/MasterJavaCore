package org.greg.BankSystem.UseCases;

import org.greg.BankSystem.Dispatcher.EventDispatcher;
import org.greg.BankSystem.Entity.Account;
import org.greg.BankSystem.Events.TransferCompletedEvent;
import org.greg.BankSystem.Contracts.AccountRepository;

public class TransferMoneyUseCase {
    private final AccountRepository accountRepository;
    private final EventDispatcher dispatcher;

    public TransferMoneyUseCase(AccountRepository accountRepository, EventDispatcher dispatcher) {
        this.accountRepository = accountRepository;
        this.dispatcher = dispatcher;
    }

    public void execute(String fromAccountId, String toAccountId, double amount) {
        Account from = accountRepository.findById(fromAccountId);
        Account to = accountRepository.findById(toAccountId);

        from.withdraw(amount);
        to.deposit(amount);

        dispatcher.dispatch(new TransferCompletedEvent(
                fromAccountId,
                toAccountId,
                amount
        ));
    }
}
