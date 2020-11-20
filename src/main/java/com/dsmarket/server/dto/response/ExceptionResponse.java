package com.dsmarket.server.dto.response;

import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class ExceptionResponse {

//    private Integer statusCode;

    private String message;

}
