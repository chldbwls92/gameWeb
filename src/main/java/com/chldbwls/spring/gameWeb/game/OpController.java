package com.chldbwls.spring.gameWeb.game;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chldbwls.spring.gameWeb.game.domain.Game;
import com.chldbwls.spring.gameWeb.game.service.OpService;

@Controller
@RequestMapping("/game")
public class OpController {
	
	private OpService opService;
	
	public OpController(OpService opService) {
		this.opService = opService;
	}
	
	@GetMapping("/create-view")
	public String gameCreate(Model model) {
		
		List<Game> gameList = opService.getAllGames();
		
		model.addAttribute("gameList", gameList);
		
		return "game/create";
	}

}
