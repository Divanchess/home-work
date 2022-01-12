package com.sbrf.reboot.atm.cassettes;

import java.util.List;

public class Cassette <T>  {
    private List<T> banknotes;

    public Cassette (List<T> banknotes) {
        this.banknotes = banknotes;
    }

    public int getCountBanknotes() {
        return banknotes.size();
    }
}
