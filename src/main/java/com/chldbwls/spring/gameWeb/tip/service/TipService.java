package com.chldbwls.spring.gameWeb.tip.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.chldbwls.spring.gameWeb.tip.domain.Tip;
import com.chldbwls.spring.gameWeb.tip.repository.TipRepository;

@Service
public class TipService {
	
	private TipRepository tipRepository;
	
	private TipService(TipRepository tipRepository) {
		this.tipRepository = tipRepository;
	}
	
	
	// 팁 추가
	public boolean addTip(
			int gameId
			, int userId
			, String contents
			, LocalDate createdAt) {
		
		// localDateTime을 dateTime으로 변경
		LocalDateTime createdAtDateTime = createdAt.atStartOfDay();
			
		
		Tip tip = Tip.builder()
		.gameId(gameId)
		.userId(userId)
		.contents(contents)
		.createdAt(createdAtDateTime)
		.build();
		
		try {
			tipRepository.save(tip);
			return true;
		} catch(Exception e) {
			return false;
		}
	}

}
