package com.dsmarket.server.controllers;


import com.dsmarket.server.dto.request.SignInRequest;
import com.dsmarket.server.dto.response.SignInResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.dsmarket.server.services.auth.AuthServiceImpl;

@RequestMapping("accounts/auth")
@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthServiceImpl authService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.OK)
    public SignInResponse signIn(@RequestBody SignInRequest signInRequest) throws Exception{
        String jwt = authService.signIn(signInRequest.getId(), signInRequest.getPassword());

        return SignInResponse
                .builder()
                .accessToken(jwt)
                .build();
    }

    @GetMapping
    public String authget() {
        authService.temp();
        return "fff";
    }
}
