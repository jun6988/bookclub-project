package com.prefix.app.readingnote.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.prefix.app.article.domain.AuditingFields;

import lombok.Data;

//@RedisHash(value = "rank", timeToLive = 30)
@Entity
@Data
public class ReadingNote extends AuditingFields{

	@Id @Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String reading_note_title;
	
	private String reading_note_hashtag;
	
	private String reading_note_content;
	
	private int reading_note_hit;
	
	private int reading_note_like;
	
	private int reading_note_bookmark;
	
	private String reading_note_file_url;
	
	private int reading_note_open;
	
//    @PrePersist
//    public void createdAt() {
//        this.created_at = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//    }
	
	
//	Account(1) : ReadingNote(N) 설정
//	@ManyToOne
	@Column(name = "account_id")
	private Long account_id;
	
//	Book(1) : ReadingNote(N) 설정
//	@ManyToOne
	@Column(name = "book_id")
	private Long book_id;
	
////	BookCategory(1) : ReadingNote(N) 설정
////	@ManyToOne
//	@Column(name = "book_category_id")
//	private Integer book_category_id;
	
////	ReadingNote(1) : ReadingNoteBookmark(N) 설정
//	@OneToMany(mappedBy = "reading_note_id")
//	public List<ReadingNoteBookmark> readingNoteBookmark;
	
//	ReadingNote(1) : ReadingNoteComment(N) 설정
	@OneToMany(mappedBy = "reading_note_id")
	public Set<ReadingNoteComment> readingNoteComment;
	
}
