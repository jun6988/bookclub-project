package com.prefix.app.readingnote.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prefix.app.readingnote.domain.ReadingProgress;
import com.prefix.app.readingnote.repository.ReadingProgressRepository;

@Service
public class ReadingProgressService {

	@Autowired
	private ReadingProgressRepository readingProgressRepository;
	
	// 리스트 처리
	public List<ReadingProgress> getReadingProgressList() {
		
		return readingProgressRepository.findAll();
	}
	
	// id 조회 처리
	public Optional<ReadingProgress> getReadingProgressListById(Long id) {
		
		return readingProgressRepository.findById(id);
	}
	
	// 작성 처리
	public ReadingProgress registReadingProgress(ReadingProgress readingProgress) {
		
		readingProgress.setAttainment_percent(readingProgress.getReading_progress_attainment() * 100 / readingProgress.getReading_progress_goal());
		
		return readingProgressRepository.save(readingProgress);
	}
	
	// 수정 처리
	public ReadingProgress updateReadingProgress(ReadingProgress readingProgress) {
		
		readingProgress.setAttainment_percent(readingProgress.getReading_progress_attainment() * 100 / readingProgress.getReading_progress_goal());
		
		return readingProgressRepository.saveAndFlush(readingProgress);
	}
	
	// 삭제 처리
	public void removeReadingProgress(Long id) {
		
		readingProgressRepository.deleteById(id);
	}
	
}
