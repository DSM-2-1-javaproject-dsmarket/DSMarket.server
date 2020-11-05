package com.dsmarket.server.dto.request;


import lombok.Builder;
import lombok.Getter;

@Getter
public class SignInRequest {

    private String id;

    private String password;
}
