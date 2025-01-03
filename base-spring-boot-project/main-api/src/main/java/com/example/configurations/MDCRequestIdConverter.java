package com.example.configurations;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import com.example.commons.enumerations.MDCKey;

public class MDCRequestIdConverter extends ClassicConverter {

    @Override
    public String convert(ILoggingEvent event) {
        String requestId = event.getMDCPropertyMap().get(MDCKey.REQUEST_ID.name());
        if (requestId != null && !requestId.isEmpty()) {
            return String.format("[RequestId : %s] ", requestId);
        }
        return "";
    }
}