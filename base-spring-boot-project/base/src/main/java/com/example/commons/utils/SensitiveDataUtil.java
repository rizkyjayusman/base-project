package com.example.commons.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SensitiveDataUtil {

    public static String mask(String value, int visibleLength) {
        if (value == null || value.length() <= visibleLength) {
            return value;
        }

        return value.substring(0, visibleLength) + "*****";
    }
}
