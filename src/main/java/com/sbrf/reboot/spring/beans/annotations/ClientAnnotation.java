package com.sbrf.reboot.spring.beans.annotations;

public class ClientAnnotation {
    private String name;

    public ClientAnnotation(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ClientAnnotation{" +
                "name='" + name + '\'' +
                '}';
    }
}
