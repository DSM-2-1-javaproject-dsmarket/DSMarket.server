package com.dsmarket.server.services.auth;

import com.dsmarket.server.dto.response.SignInResponse;
import com.dsmarket.server.entities.account.Account;

public interface AuthService {
    public String signIn(String id, String password) throws Exception;
    public void temp();
}
