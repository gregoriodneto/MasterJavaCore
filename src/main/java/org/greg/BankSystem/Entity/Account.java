package org.greg.BankSystem.Entity;

import org.greg.BankSystem.Enums.AccountType;
import org.greg.BankSystem.Enums.TransactionType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {
    private double balance;
    private Client client;
    private AccountType typeAccount;
    private List<Transaction> transactions;

    public Account(double balance, Client client, AccountType typeAccount) {
        this.client = client;
        this.typeAccount = typeAccount;
        this.transactions = new ArrayList<Transaction>();
        deposit(balance);
    }

    public void deposit(double value) {
        if (value <= 0) return;
        if (!typeAccount.canDeposit(value)) return;
        makeTransaction(value, TransactionType.DEPOSIT);
        this.balance += value;
    }

    public void withdraw(double value) {
        if (!typeAccount.canWithdraw(value, balance)) return;
        makeTransaction(value, TransactionType.WITHDRAW);
        this.balance -= value;
    }

    private void makeTransaction(double value, TransactionType type) {
        this.transactions.add(new Transaction(value, type, new Date()));
    }

    public void printStatement() {
        System.out.println("Cliente: " + client.getName());
        System.out.println("Conta: " + typeAccount + "\n");

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
