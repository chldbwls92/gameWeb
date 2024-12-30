package com.chldbwls.spring.gameWeb.review;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	
	// 리뷰 디테일 화면(게임 1개의 화면)
	@GetMapping("/detail-view")
	public String reviewDetail(
			@RequestParam("id") int id
			, Model model) {
		
		List<Game> game = opService.getGame(id);
		model.addAttribute("game", game);
		
		return "review/detail";
	}
	
	// 리뷰 생성 화면
	@GetMapping("/create-view")
	public String createReview(
			@RequestParam("id") int id
			, Model model) {
		
		List<Game> game = opService.getGame(id);
		model.addAttribute("game", game);
		
		return "review/create";
	}
	
}
