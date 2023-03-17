package com.prefix.app.article.dto.response;

import java.time.LocalDateTime;

import com.prefix.app.article.dto.ArticleDto;

public record ArticleResponse(
        Long id,
        String title,
        String content,
        String hashtag,
        LocalDateTime createdAt,
        String email,
        String nickname
) {

    public static ArticleResponse of(Long id, String title, String content, String hashtag, LocalDateTime createdAt, String email, String nickname) {
        return new ArticleResponse(id, title, content, hashtag, createdAt, email, nickname);
    }

    public static ArticleResponse from(ArticleDto dto) {
    	// 작성자 보여주는 것 (nickname 없으면 id) 
        String nickname = dto.accountDto().nickname();
        if (nickname == null || nickname.isBlank()) {
            nickname = dto.accountDto().nickname(); // 수정
        }

        return new ArticleResponse(
                dto.id(),
                dto.title(),
                dto.content(),
                dto.hashtag(),
                dto.createdAt(),
                dto.accountDto().email(),
                nickname
        );
    }

}
