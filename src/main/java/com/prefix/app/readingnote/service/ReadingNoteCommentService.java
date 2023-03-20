package com.prefix.app.readingnote.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prefix.app.readingnote.domain.ReadingNoteComment;
import com.prefix.app.readingnote.repository.ReadingNoteCommentRepository;

@Service
public class ReadingNoteCommentService {

	@Autowired
	ReadingNoteCommentRepository readingNoteCommentRepository;
	
	// 리스트 처리
	public List<ReadingNoteComment> getReadingNoteCommentList(){
		
		return readingNoteCommentRepository.findAll();
	}
	
	// id 조회 처리
	public Optional<ReadingNoteComment> getReadingNoteCommentListById(Long id) {
		
		return readingNoteCommentRepository.findById(id);
	}
	
	// 작성 치러
	public ReadingNoteComment registReadingNoteComment(ReadingNoteComment readingNoteComment) {
	
		return readingNoteCommentRepository.save(readingNoteComment);
	}
	
	// 수정 처리
	public ReadingNoteComment updateReadingNoteComment(ReadingNoteComment readingNoteComment) {
		
		return readingNoteCommentRepository.saveAndFlush(readingNoteComment);
	}
	
	// 삭제 처리
	public void removeReadingNoteComment(Long id) {
		
		readingNoteCommentRepository.deleteById(id);
	}
	
}
