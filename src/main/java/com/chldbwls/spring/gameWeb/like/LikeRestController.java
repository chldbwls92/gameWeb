package com.chldbwls.spring.gameWeb.like;


import java.util.HashMap;
import java.util.Map;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chldbwls.spring.gameWeb.like.service.LikeService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/like")
public class LikeRestController {
	
	private LikeService likeService;
	
	public LikeRestController(LikeService likeService) {
		this.likeService = likeService;	
	}

	
	@PostMapping("/add")
	public Map<String, String> addLike(
			@RequestParam("targetName") String targetName
			, @RequestParam("targetId") int targetId
			, HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId");
		
		Map<String, String> resultMap = new HashMap<>();
		if(likeService.addLike(targetName, targetId, userId)) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
			
		}
		return resultMap;	
	}
	
}
