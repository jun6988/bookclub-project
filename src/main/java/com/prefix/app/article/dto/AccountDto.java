package com.prefix.app.article.dto;

import com.prefix.app.readingnote.domain.Account;

public record AccountDto(
        String userId,
        String password,
        String email,
        String nickname
) {

    public static AccountDto of(String userId, String password, String email, String nickname) {
        return new AccountDto(userId, password, email, nickname);
    }



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
