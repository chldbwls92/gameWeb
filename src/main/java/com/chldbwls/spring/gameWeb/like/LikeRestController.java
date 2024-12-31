package com.chldbwls.spring.gameWeb.like;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/like")
public class LikeRestController {

	@PostMapping("/create")
	public Map<String, String> addLike(
			@RequestParam("targetName") String targetName
			, @RequestParam("targetId") int targetId
			, HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId");
		
		Map<String, String> resultMap = new HashMap<>();
		
	}
	
}
