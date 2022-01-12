package com.sbrf.reboot.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneOffset;

public class Account {
    private Long id;
    private LocalDate date;
    private BigDecimal balance;

    private Account() {
    }

    public static Account builder() {
        return new Account();
    }

    public Account id(Long id) {
        this.id = id;
        return this;
    }

    public Long getId() {
        return this.id;
    }

    public Account createDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public LocalDate getCreateDate() {
        return this.date;
    }

    public Account balance(BigDecimal balance) {
        this.balance = balance;
        return this;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public Account build() {
        return this;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", date=" + date.atStartOfDay(ZoneOffset.UTC).toEpochSecond() +
                ", balance=" + balance +
                '}';
    }
}
