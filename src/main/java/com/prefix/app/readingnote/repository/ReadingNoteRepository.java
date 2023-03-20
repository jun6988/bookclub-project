package com.prefix.app.readingnote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prefix.app.readingnote.domain.ReadingNote;

public interface ReadingNoteRepository extends JpaRepository<ReadingNote, Long>{

}
