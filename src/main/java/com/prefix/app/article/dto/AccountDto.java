package com.prefix.app.article.dto;

<<<<<<< HEAD
=======
import java.time.LocalDateTime;

>>>>>>> refs/remotes/origin/master
import com.prefix.app.readingnote.domain.Account;

public record AccountDto(
<<<<<<< HEAD
        String userId,
        String password,
        String email,
        String nickname
=======
        Long id,
        String nickname,
        String email,
        String password
        //LocalDateTime createdAt,
        //String createdBy,
        //LocalDateTime modifiedAt,
        //String modifiedBy
>>>>>>> refs/remotes/origin/master
) {

<<<<<<< HEAD
    public static AccountDto of(String userId, String password, String email, String nickname) {
        return new AccountDto(userId, password, email, nickname);
=======
    public static AccountDto of(Long id, String nickname, String email, String password) {
        return new AccountDto(id, email, nickname, password);
>>>>>>> refs/remotes/origin/master
    }

<<<<<<< HEAD

=======
//    public static AccountDto of(Long id, String password, String email, String nickname, LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy) {
//        return new AccountDto(id, password, email, nickname, createdAt, createdBy, modifiedAt, modifiedBy);
//    }
>>>>>>> refs/remotes/origin/master

    public static AccountDto from(Account entity) {
        return new AccountDto(
                entity.getId(),
                entity.getPassword(),
                entity.getEmail(),
                entity.getNickname()
<<<<<<< HEAD
                );
=======
                //entity.getCreatedAt(),
                //entity.getCreatedBy(),
                //entity.getModifiedAt(),
                //entity.getModifiedBy()
        );
>>>>>>> refs/remotes/origin/master
    }

    public Account toEntity() {
        return Account.of(
<<<<<<< HEAD
        		userId,
=======
                id,
>>>>>>> refs/remotes/origin/master
                password,
                email,
                nickname
        );
    }

}