package com.prefix.app.readingnote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prefix.app.readingnote.domain.ReadingNoteComment;

public interface ReadingNoteCommentRepository extends JpaRepository<ReadingNoteComment, Long>{

}
