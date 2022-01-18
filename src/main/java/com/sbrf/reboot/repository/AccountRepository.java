package com.sbrf.reboot.repository;
import java.util.Set;
import com.sbrf.reboot.dto.Account;

/**
 * Интерфейс репозитория Accounts
 */

public interface AccountRepository {
    /**
     * Получение множества Accounts по clientId.
     * @param clientId - Идентификатор клиента
     */
    Set<Account> getAllAccountsByClientId(long clientId);
}
