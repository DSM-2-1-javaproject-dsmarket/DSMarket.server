package com.dsmarket.server.error;

import com.dsmarket.server.dto.response.ExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AdviceExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleBusinessExceptions(BusinessException exception){
        return new ResponseEntity<>(
                ExceptionResponse
                        .builder()
                        .message(exception.getMessage())
//                        .statusCode(Integer.valueOf(exception.getStatusCode().toString().substring(0, 3)))
                        .build()
                , exception.getStatusCode()
        );
    }

}
