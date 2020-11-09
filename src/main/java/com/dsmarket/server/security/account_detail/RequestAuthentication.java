package com.dsmarket.server.security.account_detail;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class RequestAuthentication {
    public Authentication getAuthentication() { return SecurityContextHolder.getContext().getAuthentication(); }

    public String getAccountId() { return this.getAuthentication().getName(); }
}
