package com.prefix.app.article.repository.querydsl;

import java.util.List;

public interface ArticleRepositoryCustom {
	List<String> findAllDistinctHashtags();

}
