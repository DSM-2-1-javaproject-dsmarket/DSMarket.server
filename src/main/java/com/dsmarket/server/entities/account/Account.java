package com.dsmarket.server.entities.account;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Builder
public class Account {
    @Id
    private String id;

    @Column(nullable = false)
    private String password;

    @Column(length = 20, nullable = false, unique = true)
    private String nickName;

    @Column(length = 40, nullable = false, unique = true)
    private String email;
}
