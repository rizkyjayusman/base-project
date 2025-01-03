package com.example.configurations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LoggingObjectMapper extends ObjectMapper {
    @Override
    public String writeValueAsString(Object value) {
        try {
            return super.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            log.error("Exception on LoggingObjectMapper.writeValueAsString() - error when write value as string cause {} : {}", e.getMessage(), ExceptionUtils.getStackTrace(e));
        }

        return "{}";
    }
}
