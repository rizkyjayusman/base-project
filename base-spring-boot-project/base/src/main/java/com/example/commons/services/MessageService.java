package com.example.commons.services;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageSource messageSource;

    public String getMessage(String key) {
        return messageSource.getMessage(key, null,"Default message if not found", Locale.getDefault());
    }

    public String getMessage(String key, Object[] args) {
        return messageSource.getMessage(key, args, "Default message if not found", Locale.getDefault());
    }
}
