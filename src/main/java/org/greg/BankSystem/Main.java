package org.greg.BankSystem;

import org.greg.BankSystem.Contracts.AccountPolicy;
import org.greg.BankSystem.Entity.Account;
import org.greg.BankSystem.Entity.Client;
import org.greg.BankSystem.Enums.AccountType;
import org.greg.BankSystem.Factories.AccountPolicyFactory;

public class Main {
    public static void main(String[] args) {
        AccountPolicy policy = AccountPolicyFactory.create(AccountType.SIMPLE);

        Client c1 = new Client("José");
        Account acc1 = new Account(100, c1, policy);
        acc1.deposit(10);
        acc1.withdraw(50);
        acc1.deposit(301);
        acc1.printStatement();
    }
}
