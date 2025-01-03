package com.example.exceptions;

import com.example.commons.enumerations.ErrorCode;
import lombok.Getter;

public class BaseException extends RuntimeException {

    @Getter
    private final ErrorCode errorCode;

    public BaseException(ErrorCode code) {
        super(code.getCode());
        errorCode = code;
    }
}
