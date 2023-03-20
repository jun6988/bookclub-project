package com.prefix.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import com.prefix.app.article.domain.Article;
import com.prefix.app.article.domain.Article_Comment;
import com.prefix.app.readingnote.domain.Account;

@Configuration
public class DataRestConfig {

    @Bean
    public RepositoryRestConfigurer repositoryRestConfigurer() {
        return RepositoryRestConfigurer.withConfig((config, cors) ->
                config
                        .exposeIdsFor(Account.class)
                        .exposeIdsFor(Article.class)
                        .exposeIdsFor(Article_Comment.class)
        );
    }

}
