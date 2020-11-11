package com.dsmarket.server.dto.request;


import lombok.Builder;
import lombok.Getter;

@Getter
public class RegisterRequest {

    private String id;

    private String password;
    
    private String nickname; 
    
    private String email;
}
