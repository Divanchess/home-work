package com.sbrf.reboot.service;
import com.sbrf.reboot.entity.Account;
import com.sbrf.reboot.repository.AccountRepository;
import java.util.Set;
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
}
