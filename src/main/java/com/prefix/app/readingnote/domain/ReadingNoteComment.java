package com.prefix.app.readingnote.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class ReadingNoteComment extends Base{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String content;
	
	private int reading_note_comment_like;
	
////	Account(1) : ReadingNoteComment(N) 설정
////	@ManyToOne
////	@Column(name = "account_id")
////	private Long account_id;
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "account_id")
//	private Account account;
//	
////	ReadingNote(1) : ReadingNoteComment(N) 설정
//	@ManyToOne(fetch = FetchType.LAZY)
//	@Column(name = "reading_note_id")
//	private Long reading_note_id;
	
	
//	Account(1) : ReadingNoteComment(N) 설정
//	@ManyToOne
	@Column(name = "account_id")
	private Long account_id;
	
//	ReadingNote(1) : ReadingNoteComment(N) 설정
//	@ManyToOne
	@Column(name = "reading_note_id")
	private Long reading_note_id;
}
