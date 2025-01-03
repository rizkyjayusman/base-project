package com.example.commons.enumerations;

import lombok.Getter;

public enum CommonErrorCode implements ErrorCode {
    INTERNAL_SERVER_ERROR("internal.server.error"),
    SYSTEM_BUSY("system.is.busy"),
    ;

    @Getter
    private final String code;

    CommonErrorCode(String code) {
        this.code = code;
    }
}
