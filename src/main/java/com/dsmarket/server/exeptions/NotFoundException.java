package com.dsmarket.server.exeptions;

import com.dsmarket.server.error.BusinessErrors;
import com.dsmarket.server.error.BusinessException;

public class NotFoundException extends BusinessException {
    public NotFoundException(){
        super(BusinessErrors.NotFound);
    }
}
