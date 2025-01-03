package com.example.transaction.models.mappers;

import com.example.transaction.models.TransactionDto;
import com.example.transaction.models.requests.CreateTransactionRequest;
import com.example.transaction.models.responses.TransactionDetailResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

public interface TransactionMapper {

    @Component
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    class CreateTransactionReqMapper {

        public TransactionDto toDto(CreateTransactionRequest request) {
            TransactionDto dto = new TransactionDto();
            dto.setTransactionId(request.getTransactionId());
            return dto;
        }
    }

    @Component
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    class TransactionDetailResponseMapper {

        public TransactionDetailResponse toResponse(TransactionDto dto) {
            TransactionDetailResponse response = new TransactionDetailResponse();
            response.setTransactionId(dto.getTransactionId());
            return response;
        }
    }
}
