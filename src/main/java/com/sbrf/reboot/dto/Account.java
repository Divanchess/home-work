package com.sbrf.reboot.dto;

import lombok.NonNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Account {

    private Long id;
    private LocalDate date = LocalDate.now();
    private BigDecimal balance = BigDecimal.ZERO;
    private @NonNull String accountNumber;
    private @NonNull Long clientId;
    private String currency = "RUB";

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
    }

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

    public Account clientId(Long clientId) {
        this.clientId = clientId;
        return this;
    }

    public Long getClientId() {
        return this.clientId;
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

    public Account currency(String currency) {
        this.currency = currency;
        return this;
    }

    public String getCurrency() {
        return this.currency;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", date=" + date +
                ", balance=" + balance +
                ", accountNumber='" + accountNumber + '\'' +
                ", clientId=" + clientId +
                ", currency='" + currency + '\'' +
                '}';
    }
}