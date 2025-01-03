package com.example.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Arrays;
import java.util.stream.Stream;

@Configuration
public class MessageConfig {

    @Value("${i18n.message.available-sources}")
    private String[] availableSources;

    @Bean
    public MessageSource messageSource() {
        var messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.addBasenames(getAvailableSources());
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    private String[] getAvailableSources() {
        return Stream.concat(
            Arrays.stream(availableSources).map(module -> String.format("classpath:%s-i18n/success", module)),
            Arrays.stream(availableSources).map(module -> String.format("classpath:%s-i18n/errors", module))
        ).toArray(String[]::new);
    }
}