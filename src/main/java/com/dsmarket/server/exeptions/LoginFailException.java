package com.dsmarket.server.exeptions;

import com.dsmarket.server.error.BusinessErrors;
import com.dsmarket.server.error.BusinessException;
import lombok.Getter;

@Getter
public class LoginFailException extends BusinessException {
    public LoginFailException(){
        super(BusinessErrors.LoginFail);
    };
}
