package com.prefix.app.article.dto.response;

import java.time.LocalDateTime;

import com.prefix.app.article.dto.Article_CommentDto;

public record Article_CommentResponse(
        Long id,
        String content,
        LocalDateTime createdAt,
        String email,
        String nickname
) {

    public static Article_CommentResponse of(Long id, String content, LocalDateTime createdAt, String email, String nickname) {
        return new Article_CommentResponse(id, content, createdAt, email, nickname);
    }

    // nickname 가공 
    // user account에서 꺼내는 장면 
    public static Article_CommentResponse from(Article_CommentDto dto) {   
        String nickname = dto.accountDto().nickname(); 
        if (nickname == null || nickname.isBlank()) { 
            nickname = dto.accountDto().nickname(); 
        }

        return new Article_CommentResponse(
                dto.id(),
                dto.content(),
                dto.createdAt(),
                dto.accountDto().email(),
                dto.accountDto().nickname() // 수정
        );
    }

}
