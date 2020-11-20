package com.dsmarket.server.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum BusinessErrors {
    NotFound(HttpStatus.NOT_FOUND, "Not Found!"),
    LoginFail(HttpStatus.UNAUTHORIZED, "Login Failed"),
    AccessDenied(HttpStatus.FORBIDDEN, "Access denied");

    private final HttpStatus status;

    private final String message;

}
