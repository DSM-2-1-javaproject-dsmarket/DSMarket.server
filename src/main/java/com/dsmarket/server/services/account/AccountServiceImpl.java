package com.dsmarket.server.services.account;

import com.dsmarket.server.entities.account.Account;
import com.dsmarket.server.entities.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;

    public Account getAccountById(String id){
        return accountRepository.findById(id)
                .orElseThrow();
    }
}
