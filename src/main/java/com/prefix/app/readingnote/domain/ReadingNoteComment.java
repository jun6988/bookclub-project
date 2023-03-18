package com.prefix.app.readingnote.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.prefix.app.article.domain.AuditingFields;

import lombok.Data;

@Entity
@Data
public class ReadingNoteComment extends AuditingFields{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String content;
	
	private int reading_note_comment_like;
	
//	Account(1) : ReadingNoteComment(N) 설정
//	@ManyToOne
	@Column(name = "account_id")
	private Long account_id;
	
//	ReadingNote(1) : ReadingNoteComment(N) 설정
//	@ManyToOne
	@Column(name = "reading_note_id")
	private Long reading_note_id;
	
}
