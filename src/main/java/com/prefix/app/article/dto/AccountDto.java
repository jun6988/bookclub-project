package com.prefix.app.article.dto;

import java.time.LocalDateTime;

import com.prefix.app.readingnote.domain.Account;

public record AccountDto(
        Long id,
        String nickname,
        String email,
        String password
        //LocalDateTime createdAt,
        //String createdBy,
        //LocalDateTime modifiedAt,
        //String modifiedBy
) {

    public static AccountDto of(Long id, String nickname, String email, String password) {
        return new AccountDto(id, email, nickname, password);
    }

//    public static AccountDto of(Long id, String password, String email, String nickname, LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy) {
//        return new AccountDto(id, password, email, nickname, createdAt, createdBy, modifiedAt, modifiedBy);
//    }

    public static AccountDto from(Account entity) {
        return new AccountDto(
                entity.getId(),
                entity.getPassword(),
                entity.getEmail(),
                entity.getNickname()
                //entity.getCreatedAt(),
                //entity.getCreatedBy(),
                //entity.getModifiedAt(),
                //entity.getModifiedBy()
        );
    }

    public Account toEntity() {
        return Account.of(
                id,
                password,
                email,
                nickname
        );
    }

}