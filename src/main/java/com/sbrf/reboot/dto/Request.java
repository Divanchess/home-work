package com.sbrf.reboot.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@RequiredArgsConstructor
public class Request implements Serializable {
    @Getter
    @NonNull
    private String atmNumber;

    public Request() {
    }
}
