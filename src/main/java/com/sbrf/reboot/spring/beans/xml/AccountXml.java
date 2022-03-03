package com.sbrf.reboot.spring.beans.xml;

import java.beans.ConstructorProperties;

public class AccountXml {
    private String accountNumber;
    private ClientXml client;

    @ConstructorProperties({"accountNumber", "client"})
    public AccountXml(String accountNumber, ClientXml client) {
        this.accountNumber = accountNumber;
        this.client = client;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public ClientXml getClient() {
        return client;
    }

    public void setClient(ClientXml client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "AccountXmlConfig{" +
                "accountNumber='" + accountNumber + '\'' +
                ", client=" + client +
                '}';
    }
}
