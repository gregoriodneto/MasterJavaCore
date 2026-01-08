package org.greg.BankSystem.Entity;

import org.greg.BankSystem.Contracts.AccountPolicy;
import org.greg.BankSystem.Dispatcher.EventDispatcher;
import org.greg.BankSystem.Enums.AccountType;
import org.greg.BankSystem.Enums.TransactionType;
import org.greg.BankSystem.Events.DepositEvent;
import org.greg.BankSystem.Events.WithdrawEvent;
import org.greg.BankSystem.Listeners.EventListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {
    private double balance;
    private Client client;
    private AccountPolicy policy;
    private List<Transaction> transactions;

    private final EventDispatcher dispatcher;

    public Account(double balance, Client client, AccountPolicy policy, EventDispatcher dispatcher) {
        this.client = client;
        this.policy = policy;
        this.transactions = new ArrayList<Transaction>();
        this.dispatcher = dispatcher;
        deposit(balance);
    }

    public void deposit(double value) {
        if (value <= 0) return;
        if (!policy.canDeposit(value)) return;
        makeTransaction(value, TransactionType.DEPOSIT);
        dispatcher.dispatch(new DepositEvent(value));
        this.balance += value;
    }

    public void withdraw(double value) {
        if (!policy.canWithdraw(value, balance)) return;
        makeTransaction(value, TransactionType.WITHDRAW);
        dispatcher.dispatch(new WithdrawEvent(value));
        this.balance -= value;
    }

    private void makeTransaction(double value, TransactionType type) {
        this.transactions.add(new Transaction(value, type, new Date()));
    }

    public void printStatement() {
        System.out.println("Cliente: " + client.getName());
        System.out.println("Conta: " + policy.getName() + "\n");

        for (Transaction t: transactions) {
            String typeSignal = t.getType() == TransactionType.DEPOSIT ? "+" : "-";
            System.out.println("[" + t.getType() + "] " + typeSignal + t.getValue());
        }

        System.out.println("\n" + "Saldo atual: " + balance);
    }

    public boolean hasTransactions() {
        return !this.transactions.isEmpty();
    }

    public List<Transaction> getTransactions() {
        return this.transactions.stream().toList();
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", client=" + client.getName() +
                '}';
    }
}
