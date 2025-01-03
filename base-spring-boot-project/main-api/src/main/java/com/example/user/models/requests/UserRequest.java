package com.example.user.models.requests;

import com.example.base.SensitiveData;
import com.example.commons.utils.SensitiveDataUtil;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;

@Slf4j
@Getter @Setter
public class UserRequest implements SensitiveData, Cloneable {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String phoneNumber;

    @Override
    public SensitiveData toMaskingSensitiveData() {
        UserRequest res = new UserRequest();
        try {
            res = (UserRequest) this.clone();
            res.setUsername(SensitiveDataUtil.mask(this.username, 4));
            res.setPassword(SensitiveDataUtil.mask(this.password, 0));
            res.setEmail(SensitiveDataUtil.mask(this.email, 4));
            res.setPhoneNumber(SensitiveDataUtil.mask(this.phoneNumber, 5));
        } catch (CloneNotSupportedException e) {
            log.error("Exception on UserRequest.toMaskingSensitiveData() - failed copy to sensitive data cause {} : {}", e.getMessage(), ExceptionUtils.getStackTrace(e));
        }
        
        return res;
    }
}
