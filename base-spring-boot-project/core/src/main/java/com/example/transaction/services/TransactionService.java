package com.example.transaction.services;

import com.example.commons.enumerations.CommonErrorCode;
import com.example.exceptions.BaseException;
import com.example.transaction.models.TransactionDto;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TransactionService {
    public void createTransaction(TransactionDto dto) {
        // TODO :: process create transcation
    }

    public TransactionDto getTransactionById(String transactionId) {
        if (Objects.equals(transactionId, "trxid-001")) {
            throw new BaseException(CommonErrorCode.INTERNAL_SERVER_ERROR);
        }

        TransactionDto dto = new TransactionDto();
        dto.setTransactionId(transactionId);
        return dto;
    }
}
