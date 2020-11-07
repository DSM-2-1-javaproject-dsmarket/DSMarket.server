package com.dsmarket.server.services.auth;


import com.dsmarket.server.dto.response.SignInResponse;
import com.dsmarket.server.entities.account.Account;
import com.dsmarket.server.entities.account.repository.AccountRepository;
import com.dsmarket.server.security.JwtProvider;
import com.dsmarket.server.security.account_detail.RequestAuthentication;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import javax.naming.AuthenticationException;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final JwtProvider jwtProvider;

    private final PasswordEncoder passwordEncoder;

    private final AccountRepository accountRepository;


    public String signIn(String id, String password) throws Exception{
        Account signInAccount = accountRepository.findById(id)
                .filter(account -> passwordEncoder.matches(password, account.getPassword()))
                .orElseThrow(Exception::new);

        return jwtProvider.createToken(signInAccount.getId());
    }

    public void temp() {
        accountRepository.save(Account.builder().email("fefe").id("fefe").nickName("fefe").password(passwordEncoder.encode("qwer")).build());
    }
}
