package com.sbrf.reboot.service;

import com.sbrf.reboot.entity.Account;
import com.sbrf.reboot.repository.AccountRepository;

import java.util.Set;

public class AccountService {
    private AccountRepository accountRepository;

    public AccountService(AccountRepository repository) {
        this.accountRepository = repository;
    }

    public boolean isAccountExist(long clientId, Account account) {
        Set<Account> accounts = accountRepository.getAllAccountsByClientId(clientId);
        return accounts.contains(account);
    }
}
