package com.example.commons.enumerations;

import lombok.Getter;

public enum CommonSuccessCode implements SuccessCode {
    SUCCESS("success"),
    ;

    @Getter
    private final String code;

    CommonSuccessCode(String code) {
        this.code = code;
    }
}
