package com.prefix.app.article.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prefix.app.article.domain.Article;
import com.prefix.app.article.domain.Article_Comment;
import com.prefix.app.article.dto.Article_CommentDto;
import com.prefix.app.article.repository.ArticleRepository;
import com.prefix.app.article.repository.Article_CommentRepository;
import com.prefix.app.modules.account.domain.entity.Account;
import com.prefix.app.modules.account.infra.repository.AccountRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class Article_CommentService {

    private final ArticleRepository articleRepository;
    private final Article_CommentRepository article_CommentRepository;
    private final AccountRepository accountRepository;

    @Transactional(readOnly = true)
    // 댓글 리스트 조회 (id를 통해) 
    public List<Article_CommentDto> searchArticle_Comments(Long articleId) {
        return article_CommentRepository.findByArticle_Id(articleId)
                .stream()
                .map(Article_CommentDto::from)
                .toList();
    }

    public void saveArticle_Comment(Article_CommentDto dto) {
        try {
            Article article = articleRepository.getReferenceById(dto.articleId());
            Account account = accountRepository.getReferenceById(dto.accountDto().userId());
            article_CommentRepository.save(dto.toEntity(article, account));
        } catch (EntityNotFoundException e) {
            log.warn("댓글 저장 실패. 댓글 작성에 필요한 정보를 찾을 수 없습니다 - {}", e.getLocalizedMessage());
        }
    }

    public void updateArticle_Comment(Article_CommentDto dto) {
        try {
            Article_Comment articleComment = article_CommentRepository.getReferenceById(dto.id());
            if (dto.content() != null) { articleComment.setContent(dto.content()); }
        } catch (EntityNotFoundException e) {
            log.warn("댓글 업데이트 실패. 댓글을 찾을 수 없습니다 - dto: {}", dto);
        }
    }

    public void deleteArticle_Comment(Long article_CommentId, String userId) {
        article_CommentRepository.deleteByIdAndAccount_UserId(article_CommentId, userId);
    }

}
