package com.chldbwls.spring.gameWeb.tip;


import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chldbwls.spring.gameWeb.tip.service.TipService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/tip")
public class TipRestController {
	
	private TipService tipService;

	public TipRestController(TipService tipService) {
		this.tipService = tipService;
	}
	
	// 팁 추가
	@PostMapping("/create")
	public Map<String, String> createTip(
			@RequestParam("gameId") int gameId
			, @RequestParam("contents") String contents
			, HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId");
		
		Map<String, String> resultMap = new HashMap<>();
		if(tipService.addTip(gameId, userId, contents)) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		return resultMap;
		
	}
	
}
