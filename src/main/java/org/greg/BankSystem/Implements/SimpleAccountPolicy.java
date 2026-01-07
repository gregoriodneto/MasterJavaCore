package org.greg.BankSystem.Implements;

import org.greg.BankSystem.Contracts.AccountPolicy;
import org.greg.BankSystem.Enums.AccountType;

public class SimpleAccountPolicy implements AccountPolicy {
    @Override
    public boolean canDeposit(double value) {
        return value <= 300;
    }

    @Override
    public boolean canWithdraw(double value, double balance) {
        return value > 0 && value <= 200 && value <= balance;
    }

    @Override
    public String getName() {
        return AccountType.SIMPLE.name();
    }
}
