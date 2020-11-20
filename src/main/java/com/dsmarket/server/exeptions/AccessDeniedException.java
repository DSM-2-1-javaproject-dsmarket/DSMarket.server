package com.dsmarket.server.exeptions;

import com.dsmarket.server.error.BusinessErrors;
import com.dsmarket.server.error.BusinessException;
import org.springframework.http.HttpStatus;

public class AccessDeniedException extends BusinessException {
    public AccessDeniedException(){
        super(BusinessErrors.AccessDenied);
    }
}
