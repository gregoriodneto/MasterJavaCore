package org.greg.BankSystem.Entity;

import org.greg.BankSystem.Enums.TypeAccount;

public class Account {
    private double balance;
    private Client client;
    private TypeAccount typeAccount;

    public Account(double balance, Client client, TypeAccount typeAccount) {
        this.client = client;
        this.typeAccount = typeAccount;
        deposit(balance);
    }

    public void deposit(double value) {
        if (value <= 0) return;
        if (!typeAccount.canDeposit(value)) return;
        this.balance += value;
    }

    public void withdraw(double value) {
        if (value <= 0 || value > this.balance) return;
        this.balance -= value;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", client=" + client.getName() +
                '}';
    }
}
