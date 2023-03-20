package com.prefix.app.readingnote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prefix.app.readingnote.domain.ReadingProgress;

public interface ReadingProgressRepository extends JpaRepository<ReadingProgress, Long> {

}
