package com.prefix.app.article.dto;

import com.prefix.app.readingnote.domain.Account;

public record AccountDto(
        String userId,
        String password,
        String email,
        String nickname
) {

    public static AccountDto of(String userId, String password, String email, String nickname, String memo) {
        return new AccountDto(userId, password, email, nickname);
    }

//    public static AccountDto of(String userId, String userPassword, String email, String nickname, String memo, LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy) {
//        return new AccountDto(userId, userPassword, email, nickname, memo, createdAt, createdBy, modifiedAt, modifiedBy);
//    }

    public static AccountDto from(Account entity) {
        return new AccountDto(
                entity.getUserId(),
                entity.getPassword(),
                entity.getEmail(),
                entity.getNickname()
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