package com.dsmarket.server.entities.account.repository;

import com.dsmarket.server.entities.account.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends CrudRepository<Account, String> {
    Optional<Account> findById(String id);
    Account save(Account account);
}
