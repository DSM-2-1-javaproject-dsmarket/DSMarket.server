package com.dsmarket.server.security;

import com.dsmarket.server.entities.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        return new CustomUserDetail(accountRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("")));
    }
}
