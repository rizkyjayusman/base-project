package com.example.transaction.controllers;

import com.example.base.ApiResponse;
import com.example.commons.enumerations.CommonSuccessCode;
import com.example.commons.handlers.ApiResponseHandler;
import com.example.configurations.LoggingObjectMapper;
import com.example.transaction.models.TransactionDto;
import com.example.transaction.models.mappers.TransactionMapper;
import com.example.transaction.models.requests.CreateTransactionRequest;
import com.example.transaction.models.responses.TransactionDetailResponse;
import com.example.transaction.services.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("${endpoints.transactions.base}")
public class TransactionController {

    private final TransactionService transactionService;
    private final ApiResponseHandler apiResponseHandler;
    private final LoggingObjectMapper objectMapper;

    private final TransactionMapper.CreateTransactionReqMapper createTransactionReqMapper;
    private final TransactionMapper.TransactionDetailResponseMapper transactionDetailResponseMapper;

    @PostMapping
    public ResponseEntity<ApiResponse<Void>> createTransaction(@RequestBody CreateTransactionRequest request) {
        log.info("Execute TransactionController.createTransaction() - start creating transaction");
        log.debug("Execute TransactionController.createTransaction() - parameter : {}", objectMapper.writeValueAsString(request));

        transactionService.createTransaction(createTransactionReqMapper.toDto(request));

        return apiResponseHandler.constructSuccessResponse(CommonSuccessCode.SUCCESS);
    }

    @GetMapping("/{transactionId}")
    public ResponseEntity<ApiResponse<TransactionDetailResponse>> getTransactionById(@PathVariable String transactionId) {
        log.info("Execute TransactionController.getTransactionId() - Get transaction by id: {}", transactionId);

        TransactionDto res = transactionService.getTransactionById(transactionId);

        return apiResponseHandler.constructSuccessResponse(CommonSuccessCode.SUCCESS, transactionDetailResponseMapper.toResponse(res));
    }
}
