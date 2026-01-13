package org.greg.BankSystem.Repositories;

import org.greg.BankSystem.Contracts.AccountRepository;
import org.greg.BankSystem.Entity.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountImplementsRepository implements AccountRepository {
    private final List<Account> accounts = new ArrayList<>();

    @Override
    public Account findById(String id) {
        return accounts.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Account account) {
        accounts.add(account);
    }
}
