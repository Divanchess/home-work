package com.sbrf.reboot.service;

import com.sbrf.reboot.entity.Account;
import com.sbrf.reboot.repository.AccountRepository;
import java.util.Set;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccountService {

    @NonNull
    private AccountRepository accountRepository;

    public boolean isAccountExist(long clientId, Account account) {
        Set<Account> accounts = accountRepository.getAllAccountsByClientId(clientId);
        return accounts.contains(account);
    }
}
