package org.greg.BankSystem;

import org.greg.BankSystem.Entity.Account;
import org.greg.BankSystem.Entity.Client;
import org.greg.BankSystem.Enums.TypeAccount;

public class Main {
    static void main() throws Exception {
        Client c1 = new Client("José");
        Account acc1 = new Account(100, c1, TypeAccount.SIMPLE);
        acc1.deposit(10);
        acc1.withdraw(50);
        acc1.deposit(301);
        System.out.println(acc1);
    }
}
