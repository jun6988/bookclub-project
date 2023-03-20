package com.prefix.app.readingnote.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
<<<<<<< HEAD
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String book_title;
	
	private String book_ISBN;
	
	private String book_author;
	
	private String book_publisher;
	
	private String book_img_url;
	
////	BookCategory(1) : Book(N) 설정
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "book_category_id")
//	private BookCategory bookCategory;
//	
////	Book(1) : ReadingNote(N) 설정
//	@OneToMany(mappedBy = "book_id")
//	public Set<ReadingNote> readingNote;
=======
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String book_title;
	
	private String book_ISBN;
	
	private String book_author;
	
	private String book_publisher;
	
	private String book_img_url;
>>>>>>> refs/remotes/origin/master
	
//	BookCategory(1) : Book(N) 설정
//	@ManyToOne
	@Column(name = "book_category_id")
	private Long book_category_id;
	
//	Book(1) : ReadingNote(N) 설정
	@OneToMany(mappedBy = "book_id")
	public Set<ReadingNote> readingNote;
	
}
