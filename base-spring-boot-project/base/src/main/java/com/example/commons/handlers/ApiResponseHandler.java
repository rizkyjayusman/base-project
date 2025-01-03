package com.example.commons.handlers;

import com.example.base.ApiResponse;
import com.example.commons.enumerations.SuccessCode;
import com.example.commons.services.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApiResponseHandler {

    private final MessageService messageService;

    public ResponseEntity<ApiResponse<Void>> constructSuccessResponse(SuccessCode successCode) {
        return constructSuccessResponse(successCode, null, null);
    }

    public <T> ResponseEntity<ApiResponse<T>> constructSuccessResponse(SuccessCode successCode, T data) {
        return constructSuccessResponse(successCode, data, null);
    }

    public <T> ResponseEntity<ApiResponse<T>> constructSuccessResponse(SuccessCode successCode, T data, Object[] messageArgs)
    {
        ApiResponse<T> res = new ApiResponse<>();
        res.setSuccess(Boolean.TRUE);
        res.setCode(successCode.getCode());
        res.setMessage(messageService.getMessage(successCode.getCode(), messageArgs));
        res.setData(data);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
