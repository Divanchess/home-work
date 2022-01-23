package com.sbrf.reboot.parallels.objects;

import java.time.LocalDate;

public class Account {
    private Long balance;
    private int currency;
    private LocalDate createDate;

    public Account(Long balance, int currency, LocalDate createDate) {
        this.balance = balance;
        this.currency = currency;
        this.createDate = createDate;
    }

    public int getCurrency() {
        return currency;
    }

    public Long getBalance() {
        return balance;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", currency=" + currency +
                ", createDate=" + createDate +
                '}';
    }
}
