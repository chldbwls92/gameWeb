package com.chldbwls.spring.gameWeb.review;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/review")
public class ReviewController {
	
	// 리뷰 메인화면
	@GetMapping("/main-view")
	public String reviewMain() {
		return "review/main";
	}

}
