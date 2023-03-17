package com.prefix.app.modules.account.domain;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.prefix.app.article.dto.AccountDto;
import com.prefix.app.modules.account.domain.entity.Account;

import lombok.Getter;

public class UserAccount extends User {
    @Getter
    private final Account account;

    public UserAccount(Account account) {
        super(account.getNickname(), account.getPassword(), List.of(new SimpleGrantedAuthority("ROLE_USER")));
        this.account = account;
    }
    
    // june
    public AccountDto getAccountDto() {
        return AccountDto.from(this.account);
    }
}