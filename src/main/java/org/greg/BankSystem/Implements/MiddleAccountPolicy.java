package org.greg.BankSystem.Implements;

import org.greg.BankSystem.Contracts.AccountPolicy;
import org.greg.BankSystem.Enums.AccountType;

public class MiddleAccountPolicy implements AccountPolicy {
    @Override
    public boolean canDeposit(double value) {
        return value <= 1000;
    }

    @Override
    public boolean canWithdraw(double value, double balance) {
        return value > 0 && value <= 500 && value <= balance;
    }

    @Override
    public String getName() {
        return AccountType.MIDDLE.name();
    }
}
