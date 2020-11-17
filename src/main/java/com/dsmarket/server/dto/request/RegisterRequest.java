package com.dsmarket.server.dto.request;


import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;

@Getter
public class RegisterRequest implements Serializable
{

    private String id;

    private String password;
    
    private String nickname; 
    
    private String email;
}
