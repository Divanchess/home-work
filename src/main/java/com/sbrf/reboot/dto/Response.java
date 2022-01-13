package com.sbrf.reboot.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@RequiredArgsConstructor
public class Response implements Serializable {
    @Getter
    @NonNull
    public String statusCode;

    public Response() {
    }
}
