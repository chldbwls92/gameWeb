package com.chldbwls.spring.gameWeb.review;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chldbwls.spring.gameWeb.game.domain.Game;
import com.chldbwls.spring.gameWeb.game.service.OpService;

@Controller
@RequestMapping("/review")
public class ReviewController {
	
	private OpService opService;
	
	public ReviewController(OpService opService) {
		this.opService = opService;
	}
	
	// 리뷰 메인화면
	@GetMapping("/main-view")
	public String reviewMain(Model model) {
		
		List<Game> gameList = opService.getAllGames();
		
		model.addAttribute("gameList", gameList);
		
		return "review/main";
	}

}
