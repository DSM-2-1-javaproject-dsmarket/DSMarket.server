package com.dsmarket.server.error;


import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
public class BusinessException extends RuntimeException {
    private HttpStatus statusCode;

    public BusinessException(BusinessErrors errors) {
        super(errors.getMessage());
        this.statusCode = errors.getStatus();
    }
}
