package com.example.user.enumerations;

import com.example.commons.enumerations.SuccessCode;
import lombok.Getter;

public enum UserSuccessCode implements SuccessCode {
    GET_ALL("user.success.all"),
    DETAIL("user.success.detail"),
    CREATED("user.success.created"),
    ;

    @Getter
    private final String code;

    UserSuccessCode(String code) {
        this.code = code;
    }
}
