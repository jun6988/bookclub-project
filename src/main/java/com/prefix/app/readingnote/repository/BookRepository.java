package com.prefix.app.readingnote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prefix.app.readingnote.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
