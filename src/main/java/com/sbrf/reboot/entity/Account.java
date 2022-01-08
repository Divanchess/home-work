package com.sbrf.reboot.entity;
import lombok.RequiredArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
public class Account {

    @Getter
    @NonNull
    private String accountNumber;

}
