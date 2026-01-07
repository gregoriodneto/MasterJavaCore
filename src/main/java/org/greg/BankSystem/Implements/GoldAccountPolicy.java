package org.greg.BankSystem.Implements;

import org.greg.BankSystem.Contracts.AccountPolicy;
import org.greg.BankSystem.Enums.AccountType;

public class GoldAccountPolicy implements AccountPolicy {
    @Override
    public boolean canDeposit(double value) {
        return true;
    }

    @Override
    public boolean canWithdraw(double value, double balance) {
        return value > 0 && value <= balance;
    }

    @Override
    public String getName() {
        return AccountType.GOLD.name();
    }
}
