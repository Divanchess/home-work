package com.sbrf.reboot.spring.beans.xml;

public class ClientXml {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ClientXmlConfig{" +
                "name='" + name + '\'' +
                '}';
    }
}
