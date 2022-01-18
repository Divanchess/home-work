package com.sbrf.reboot.service;
import com.sbrf.reboot.dto.Account;
import com.sbrf.reboot.repository.AccountRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Класс для операций над репозиторием счетов
 */

@RequiredArgsConstructor
public class AccountService {

    /** Объект, относящийся к интерфейсу репозитория счетов */
    @NonNull
    private AccountRepository accountRepository;

    /**
     * Проверка существует ли счет в репозитории.
     * @param clientId - Идентификатор клиента
     * @param account - объект Счета
     * @return boolean.
     */
    public boolean isAccountExist(long clientId, Account account) {
        Set<Account> accounts = accountRepository.getAllAccountsByClientId(clientId);
        return accounts.contains(account);
    }

    public Account getMaxAccountBalance(Long clientId) {
        Set<Account> accounts = accountRepository.getAllAccountsByClientId(clientId);
        Account accMaxBalance = accounts.stream()
                .filter(account -> account.getClientId().equals(1L))
                .max(new Comparator<Account>() {
                    @Override
                    public int compare(Account o1, Account o2) {
                        return o1.getBalance().compareTo(o2.getBalance());
                    }
                })
                .get();
        return accMaxBalance;
    }

    public Set<Account> getAllAccountsByDateMoreThen(Long clientId, LocalDate compareDate) {
        Set<Account> accounts = accountRepository.getAllAccountsByClientId(clientId);
        Set<Account> accountsMoreThenDate = accounts.stream()
                .filter(account -> account.getClientId().equals(1L))
                .filter(account -> account.getCreateDate().compareTo(compareDate) >= 0)
                .collect(Collectors.toSet());
        return accountsMoreThenDate;
    }

    public Set<Account> getRUBAccountsPositive(Long clientId) {
        Set<Account> accounts = accountRepository.getAllAccountsByClientId(clientId);
        System.out.println(accounts);
        Set<Account> accountsRUBPositive = accounts.stream()
                .filter(account -> account.getClientId().equals(1L))
                .filter(account -> account.getBalance().compareTo(BigDecimal.ZERO) > 0)
                .filter(account -> account.getCurrency().equals("RUB"))
                .collect(Collectors.toSet());
        return accountsRUBPositive;
    }
}
