package com.sbrf.reboot.repository;

import java.util.Set;
import com.sbrf.reboot.entity.Account;

public interface AccountRepository {
    Set<Account> getAllAccountsByClientId(long clientId);
}
