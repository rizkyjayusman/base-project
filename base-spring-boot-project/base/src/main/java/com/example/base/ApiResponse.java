package com.example.base;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ApiResponse<T> {
    private boolean success;
    private String code;
    private String message;
    private T data;
}
