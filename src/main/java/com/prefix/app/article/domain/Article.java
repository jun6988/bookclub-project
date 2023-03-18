package com.prefix.app.article.domain;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.prefix.app.readingnote.domain.Account;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@ToString(callSuper = true) 
@Table(indexes = { 
		@Index(columnList = "id"),
        @Index(columnList = "title"),
        @Index(columnList = "hashtag"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})

@Entity 
public class Article extends AuditingFields {  

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id; 

  
    @Setter @ManyToOne(optional = false) @JoinColumn(name = "account_id") private Account account;


    @Setter @Column(nullable = false) private String title; 
    @Setter @Column(nullable = false, length = 10000) private String content; 

    @Setter private String hashtag; 

    
    @ToString.Exclude 
    @OrderBy("createdAt DESC") 
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL) 
    private final Set<Article_Comment> article_Comments = new LinkedHashSet<>();


  
    protected Article() {}

    private Article(Account account, String title, String content, String hashtag) {
        this.account = account;
        this.title = title;
        this.content = content;
        this.hashtag = hashtag;
    }

  
    public static Article of(Account account, String title, String content, String hashtag) {
        return new Article(account, title, content, hashtag);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article that)) return false;
        return id != null && id.equals(that.getId()); 
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
