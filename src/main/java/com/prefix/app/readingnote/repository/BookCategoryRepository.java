package com.prefix.app.readingnote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prefix.app.readingnote.domain.BookCategory;

public interface BookCategoryRepository extends JpaRepository<BookCategory, Long>{

}
