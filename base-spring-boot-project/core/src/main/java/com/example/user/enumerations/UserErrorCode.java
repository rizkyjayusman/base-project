package com.example.user.enumerations;

import com.example.commons.enumerations.ErrorCode;
import lombok.Getter;

public enum UserErrorCode implements ErrorCode {
    USER_ID_INVALID("user.error.user-id-invalid"),
    ;

    @Getter
    private final String code;

    UserErrorCode(String code) {
        this.code = code;
    }
}
