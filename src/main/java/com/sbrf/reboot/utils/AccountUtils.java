package com.sbrf.reboot.utils;

import com.sbrf.reboot.dto.Account;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AccountUtils {
    public static List<Account> sortedById(List<Account> accounts) {
         Collections.sort(accounts, new Comparator<Account>() {
            @Override
            public int compare(Account o1, Account o2) {
                return o1.getId().compareTo(o2.getId());
            }
        });
        return accounts;
    }

    public static List<Account> sortedByIdDate(List<Account> accounts) {
        Collections.sort(accounts, new Comparator<Account>() {
            @Override
            public int compare(Account o1, Account o2) {

                int result = o1.getId().compareTo(o2.getId());
                if (result != 0) {
                    return result;
                }
                return o1.getCreateDate().compareTo(o2.getCreateDate());
            }
        });
        return accounts;
    }

    public static List<Account> sortedByIdDateBalance(List<Account> accounts) {
        Collections.sort(accounts, new Comparator<Account>() {
            @Override
            public int compare(Account o1, Account o2) {
                int result = o1.getId().compareTo(o2.getId());
                if (result != 0) {
                    return result;
                }
                result = o1.getCreateDate().compareTo(o2.getCreateDate());
                if (result != 0) {
                    return result;
                }
                return o1.getBalance().compareTo(o2.getBalance());
            }
        });
        return accounts;
    }
}
