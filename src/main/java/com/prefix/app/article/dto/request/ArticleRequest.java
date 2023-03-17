package com.prefix.app.article.dto.request;

import com.prefix.app.article.dto.AccountDto;
import com.prefix.app.article.dto.ArticleDto;

public record ArticleRequest(
        String title,
        String content,
        String hashtag
) {

    public static ArticleRequest of(String title, String content, String hashtag) {
        return new ArticleRequest(title, content, hashtag);
    }

    public ArticleDto toDto(AccountDto accountDto) {
        return ArticleDto.of(
                accountDto,
                title,
                content,
                hashtag
        );
    }

}