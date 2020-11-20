package com.dsmarket.server.services.auth;

import com.dsmarket.server.error.BusinessException;

public interface AuthService {
    public String signIn(String id, String password) throws BusinessException;
    public void temp();
}
