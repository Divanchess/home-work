package com.sbrf.reboot.spring.beans.annotations;

public class AccountAnnotation {
    private String accountNumber;
    private String currency;
    private ClientAnnotation client;

    public AccountAnnotation(String accountNumber, String currency, ClientAnnotation client) {
        this.accountNumber = accountNumber;
        this.currency = currency;
        this.client = client;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public ClientAnnotation getClient() {
        return client;
    }

    public void setClient(ClientAnnotation client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "AccountAnnotation{" +
                "accountNumber='" + accountNumber + '\'' +
                ", currency='" + currency + '\'' +
                ", client=" + client +
                '}';
    }

    public void printInitMessage() {
        System.out.println( "\nInit method in Account Annotation class\n");
    }
}
