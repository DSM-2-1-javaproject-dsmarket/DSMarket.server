package com.dsmarket.server.controllers;


import com.dsmarket.server.dto.response.SignInResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.dsmarket.server.services.auth.AuthServiceImpl;

@RequestMapping("/auth")
@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthServiceImpl authService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.OK)
    public SignInResponse signIn(){
        return (SignInResponse)null;
    }
}
