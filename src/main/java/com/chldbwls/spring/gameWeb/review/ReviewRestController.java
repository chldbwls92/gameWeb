package com.chldbwls.spring.gameWeb.review;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chldbwls.spring.gameWeb.review.service.ReviewService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/review")
public class ReviewRestController {
	
	private ReviewService reviewService;
	
	public ReviewRestController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}
	
	
	// review 추가
	@PostMapping("/create")
	public Map<String, String> createReview(
			@RequestParam("gameId") int gameId
			, @RequestParam("contents") String contents
			, @RequestParam("rating") int rating
			, HttpSession session) {
		
		// 어떤 사용자인지 알기 위해
		int userId = (Integer)session.getAttribute("userId");
		
		Map<String, String> resultMap = new HashMap<>();
		if(reviewService.addReview(gameId, userId, contents, rating)) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		return resultMap;
		
	}

}
