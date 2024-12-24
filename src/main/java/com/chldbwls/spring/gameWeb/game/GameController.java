package com.chldbwls.spring.gameWeb.game;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("game")
public class GameController {
	
	@GetMapping("create-view")
	public String gameCreate() {
		return "game/create";
		
	}
}
