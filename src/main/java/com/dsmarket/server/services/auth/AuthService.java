package com.dsmarket.server.services.auth;

import com.dsmarket.server.dto.response.SignInResponse;

public interface AuthService {
    public SignInResponse signIn();
}
