package com.prefix.app.article.dto.request;

import com.prefix.app.article.dto.AccountDto;
import com.prefix.app.article.dto.Article_CommentDto;

public record Article_CommentRequest(Long articleId, String content) {

    public static Article_CommentRequest of(Long articleId, String content) {
        return new Article_CommentRequest(articleId, content);
    }

    public Article_CommentDto toDto(AccountDto accountDto) {
        return Article_CommentDto.of(
                articleId,
                accountDto,
                content
        );
    }

}
