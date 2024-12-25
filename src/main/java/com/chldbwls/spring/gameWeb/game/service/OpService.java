package com.chldbwls.spring.gameWeb.game.service;

import org.springframework.stereotype.Service;

import com.chldbwls.spring.gameWeb.game.domain.Game;
import com.chldbwls.spring.gameWeb.game.repository.OpRepository;

@Service
public class OpService {
	
	private OpRepository opRepository;
	
	private OpService(OpRepository opRepository) {
		this.opRepository = opRepository;
	}
	
	// 게임 추가
	public boolean addGame(
			String title
			, String imagePath) {
		
		Game game = Game.builder()
		.title(title)
		.imagePath(imagePath)
		.build();
		
		try {
			opRepository.save(game);
			return true;
		} catch(Exception e) {
			return false;
		}
		
	}

}
