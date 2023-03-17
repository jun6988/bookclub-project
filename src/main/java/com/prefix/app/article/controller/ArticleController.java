package com.prefix.app.article.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prefix.app.article.domain.constant.SearchType;
import com.prefix.app.article.dto.AccountDto;
import com.prefix.app.article.dto.request.ArticleRequest;
import com.prefix.app.article.dto.response.ArticleResponse;
import com.prefix.app.article.dto.response.ArticleWithCommentsResponse;
import com.prefix.app.article.service.ArticleService;
import com.prefix.app.article.service.PaginationService;

@RequestMapping("/articles") // 모든 view endpoint가 articles로 시작 
@RestController
public class ArticleController {

    private final ArticleService articleService;
    private final PaginationService paginationService;
    
    public ArticleController(ArticleService articleService, PaginationService paginationService) {
        this.articleService = articleService;
        this.paginationService = paginationService;
    }

    // 게시글 리스트 페이지 불러오기 
    @GetMapping
    public Page<ArticleResponse> articles(
    		// 검색어를 입력하면 검색기능으로 넘어가게 설정 
            @RequestParam(required = false) SearchType searchType,
            @RequestParam(required = false) String searchValue,
            // 게시판 정렬 기능 
            @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable
    ) {
    	// DTO를 가공한 map을 사용하여 ArticleResponse 게시글(댓글 필요 없음) 불러온다. 
        Page<ArticleResponse> articles = articleService.searchArticles(searchType, searchValue, pageable).map(ArticleResponse::from);
        return articles;
    }

    // 게시글 단건 조회 
    @GetMapping("/{articleId}")
    public ArticleWithCommentsResponse article(@PathVariable Long articleId) {
        ArticleWithCommentsResponse article = ArticleWithCommentsResponse.from(articleService.getArticleWithComments(articleId));
        return article;
    }

    @GetMapping("/search-hashtag")
    public Page<ArticleResponse> searchArticleHashtag(
            @RequestParam(required = false) String searchValue,
            @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        Page<ArticleResponse> articles = articleService.searchArticlesViaHashtag(searchValue, pageable).map(ArticleResponse::from);
        return articles;
    }
    
    @PostMapping("/form")
    public void postNewArticle(
            @AuthenticationPrincipal(expression = "accountDto") AccountDto accountDto,
            ArticleRequest articleRequest
    ) {
        articleService.saveArticle(articleRequest.toDto(accountDto));
    }

    @PostMapping("/{articleId}/form")
    public void updateArticle(
    		@PathVariable(name = "articleId") Long articleId,
            @AuthenticationPrincipal(expression = "accountDto") AccountDto accountDto,
            ArticleRequest articleRequest
    ) {
        articleService.updateArticle(articleId, articleRequest.toDto(accountDto));
    }

    @PostMapping("/{articleId}/delete")
    public void deleteArticle(
    		@PathVariable(name = "articleId") Long articleId,
            @AuthenticationPrincipal(expression = "accountDto") AccountDto accountDto
    ) {
        articleService.deleteArticle(articleId, accountDto.userId());
    }

//    @PostMapping("/form")
//    public void postNewArticle(
//            @AuthenticationPrincipal BoardPrincipal boardPrincipal,
//            ArticleRequest articleRequest
//    ) {
//        articleService.saveArticle(articleRequest.toDto(boardPrincipal.toDto()));
//    }
//
//    @PostMapping("/{articleId}/form")
//    public void updateArticle(
//            @PathVariable Long articleId,
//            @AuthenticationPrincipal BoardPrincipal boardPrincipal,
//            ArticleRequest articleRequest
//    ) {
//        articleService.updateArticle(articleId, articleRequest.toDto(boardPrincipal.toDto()));
//    }
//
//    @PostMapping("/{articleId}/delete")
//    public void deleteArticle(
//            @PathVariable Long articleId,
//            @AuthenticationPrincipal BoardPrincipal boardPrincipal
//    ) {
//        articleService.deleteArticle(articleId, boardPrincipal.getUsername());
//    }
}
