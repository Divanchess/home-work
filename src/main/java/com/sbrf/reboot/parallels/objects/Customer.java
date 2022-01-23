package com.sbrf.reboot.parallels.objects;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Customer {
    private int age;
    private String name;
    private List<Account> accounts;

    public Customer(int age, String name, List<Account> accounts) {
        this.age = age;
        this.name = name;
        this.accounts = accounts;
    }

    public int getAge() {
        return age;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public List<Account> getAccountsBetweenDates(LocalDate from, LocalDate to) {
        List<Account> accountsBetweenDates = accounts.stream()
                .filter(account ->
                        account.getCreateDate().compareTo(from) >=0
                        && account.getCreateDate().compareTo(to) < 0)
                .collect(Collectors.toList());
        return accountsBetweenDates;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
