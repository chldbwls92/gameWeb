package com.chldbwls.spring.gameWeb.tip;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chldbwls.spring.gameWeb.game.domain.Game;
import com.chldbwls.spring.gameWeb.game.service.OpService;
import com.chldbwls.spring.gameWeb.tip.dto.TipDTO;
import com.chldbwls.spring.gameWeb.tip.service.TipService;
import com.chldbwls.spring.gameWeb.user.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/tip")
public class TipController {
	
	private OpService opService;
	private TipService tipService;
	private UserService userService;
	
	public TipController(
			OpService opService
			, TipService tipService
			, UserService userService) {
		this.opService = opService;
		this.tipService = tipService;
		this.userService = userService;
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
			@RequestParam("gameId") int gameId
			, Model model
			, HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId");
		
		List<TipDTO> tipDTOList = tipService.getTipList(gameId, userId);
		Game game = opService.getGame(gameId);
		
		model.addAttribute("game", game);
		model.addAttribute("tipList", tipDTOList);
		
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
