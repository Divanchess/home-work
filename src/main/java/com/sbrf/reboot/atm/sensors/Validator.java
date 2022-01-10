package com.sbrf.reboot.atm.sensors;

import java.util.List;

public class Validator<T> {
    private List<T> sensors;
    private static boolean isSuccess;

    public Validator(List<T> sensors) {
        this.sensors = sensors;
    }

    public boolean validate() {
        return true;
    }
}
