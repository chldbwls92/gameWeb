package com.chldbwls.spring.gameWeb.review;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chldbwls.spring.gameWeb.game.domain.Game;
import com.chldbwls.spring.gameWeb.game.service.OpService;
import com.chldbwls.spring.gameWeb.review.dto.ReviewDTO;
import com.chldbwls.spring.gameWeb.review.service.ReviewService;
import com.chldbwls.spring.gameWeb.user.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/review")
public class ReviewController {
	
	private OpService opService;
	private ReviewService reviewService;
	private UserService userService;
	
	public ReviewController(
			OpService opService
			, ReviewService reviewService) {
		this.opService = opService;
		this.reviewService = reviewService;
		this.userService = userService;
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
			@RequestParam("id") int gameId
			, HttpSession session
			, Model model) {

		
		int userId = (Integer)session.getAttribute("id");
		
		// 특정 게임의 리뷰리스트
		List<ReviewDTO> reviewDTOList = reviewService.getReviewList(gameId, userId);
		Game game = opService.getGame(gameId);
		
		// model 이용하여 데이터 추가
		model.addAttribute("game", game);
		model.addAttribute("reviewList", reviewDTOList);

		return "review/detail";
	}
	
	// 리뷰 생성 화면
	@GetMapping("/create-view")
	public String createReview(
			@RequestParam("id") int id
			, Model model) {
		
		Game game = opService.getGame(id);
		model.addAttribute("game", game);
		
		return "review/create";
	}
	
}
