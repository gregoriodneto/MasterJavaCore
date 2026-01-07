package org.greg.BankSystem;

import org.greg.BankSystem.Entity.Account;
import org.greg.BankSystem.Entity.Client;
import org.greg.BankSystem.Enums.AccountType;

public class Main {
    public static void main(String[] args) {
        Client c1 = new Client("José");
        Account acc1 = new Account(100, c1, AccountType.SIMPLE);
        acc1.deposit(10);
        acc1.withdraw(50);
        acc1.deposit(301);
        acc1.printStatement();
    }
}
