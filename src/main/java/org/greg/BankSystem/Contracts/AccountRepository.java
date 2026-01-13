package org.greg.BankSystem.Contracts;

import org.greg.BankSystem.Entity.Account;

public interface AccountRepository {
    Account findById(String id);
    void save(Account account);
}
