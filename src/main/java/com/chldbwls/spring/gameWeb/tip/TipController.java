package com.chldbwls.spring.gameWeb.tip;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chldbwls.spring.gameWeb.game.domain.Game;
import com.chldbwls.spring.gameWeb.game.service.OpService;

@Controller
@RequestMapping("/tip")
public class TipController {
	
	private OpService opService;
	
	public TipController(OpService opService) {
		this.opService = opService;
	}
	
	
	// 팁 메인화면
		@GetMapping("/main-view")
		public String reviewMain(Model model) {
			
			List<Game> gameList = opService.getAllGames();
			
			model.addAttribute("gameList", gameList);
			
			return "tip/main";
		}

}
