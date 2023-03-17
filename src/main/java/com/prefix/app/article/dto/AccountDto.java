package com.prefix.app.article.dto;

import java.time.LocalDateTime;

import com.prefix.app.modules.account.domain.entity.Account;

public record AccountDto(
        String userId,
        String password,
        String email,
        String nickname,
        LocalDateTime createdDate,
        LocalDateTime lastModifiedDate
) {

    public static AccountDto of(String userId, String password, String email, String nickname) {
        return new AccountDto(userId, password, email, nickname, null, null);
    }

    public static AccountDto of(String userId, String password, String email, String nickname, LocalDateTime createdDate, LocalDateTime lastModifiedDate) {
        return new AccountDto(userId, password, email, nickname, createdDate, lastModifiedDate);
    }

    public static AccountDto from(Account entity) {
        return new AccountDto(
                entity.getUserId(),
                entity.getPassword(),
                entity.getEmail(),
                entity.getNickname(),
                entity.getCreatedDate(),
                entity.getLastModifiedDate()
                );
    }

    public Account toEntity() {
        return Account.of(
                userId,
                password,
                email,
                nickname
        );
    }

}
