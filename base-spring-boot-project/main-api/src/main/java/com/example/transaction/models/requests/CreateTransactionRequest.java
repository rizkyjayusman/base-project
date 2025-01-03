package com.example.transaction.models.requests;

import com.example.base.SensitiveData;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;

@Slf4j
@Getter @Setter
public class CreateTransactionRequest implements SensitiveData {
    private String transactionId;

    @Override
    public CreateTransactionRequest toMaskingSensitiveData() {
        CreateTransactionRequest res = new CreateTransactionRequest();
        try {
            res = (CreateTransactionRequest) this.clone();
        } catch (CloneNotSupportedException e) {
            log.error("Exception on UserRequest.toMaskingSensitiveData() - failed copy to sensitive data cause {} : {}", e.getMessage(), ExceptionUtils.getStackTrace(e));
        }

        return res;
    }
}
