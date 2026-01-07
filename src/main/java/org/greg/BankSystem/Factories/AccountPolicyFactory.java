package org.greg.BankSystem.Factories;

import org.greg.BankSystem.Contracts.AccountPolicy;
import org.greg.BankSystem.Enums.AccountType;
import org.greg.BankSystem.Implements.GoldAccountPolicy;
import org.greg.BankSystem.Implements.MiddleAccountPolicy;
import org.greg.BankSystem.Implements.SimpleAccountPolicy;

public class AccountPolicyFactory {
    public static AccountPolicy create(AccountType type) {
        return switch (type) {
            case MIDDLE -> new MiddleAccountPolicy();
            case GOLD -> new GoldAccountPolicy();
            default -> new SimpleAccountPolicy();
        };
    }
}
