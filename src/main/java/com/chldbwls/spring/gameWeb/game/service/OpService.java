package com.chldbwls.spring.gameWeb.game.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.chldbwls.spring.gameWeb.common.FileManager;
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
	
	// 모든 게임 보이게
	public List<Game> getAllGames() {
        List<Game> gameList = opRepository.findAll();
        return gameList;
    }
	
	// 특정 게임 하나
	public List<Game> getGame(int id) {
		List<Game> game = opRepository.findAllByid(id);
		return game;
	}
	
	// 게임 삭제
	public boolean deleteGame(int id) {
		
		Optional<Game> optionalGame = opRepository.findById(id);
		
		if(optionalGame.isPresent()) {
			Game game = optionalGame.get();
			FileManager.deleteFile(game.getImagePath());
			opRepository.delete(game);
			return true;
		} else {
			return false;
		}
	}
	

}
