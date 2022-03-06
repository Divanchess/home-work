package com.sbrf.reboot.entity;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;


/**
 * Класс хранящий номера счетов
 */

@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class Account {

    /** Номер счета */
    @Getter
    @NonNull
    private String accountNumber;
}
