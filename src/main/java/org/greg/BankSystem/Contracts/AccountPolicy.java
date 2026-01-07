package org.greg.BankSystem.Contracts;

public interface AccountPolicy {
    boolean canDeposit(double value);
    boolean canWithdraw(double value, double balance);
    String getName();
}
