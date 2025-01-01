package com.chldbwls.spring.gameWeb.tip;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String tipMain(Model model) {
		
		List<Game> gameList = opService.getAllGames();
		model.addAttribute("gameList", gameList);
		
		return "tip/main";
	}

	// 팁 세부화면
	@GetMapping("/detail-view")
	public String detailTip(
			@RequestParam("id") int id
			, Model model) {
		
		Game game = opService.getGame(id);
		model.addAttribute("game", game);
		
		return "tip/detail";
	}
	
	// 팁 생성 화면
	@GetMapping("/create-view")
	public String createTip(
			@RequestParam("id") int id
			, Model model) {
		
		Game game = opService.getGame(id);
		model.addAttribute("game", game);
		
		return "tip/create";
	}
	
	
	
		
}
