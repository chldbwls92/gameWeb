package com.chldbwls.spring.gameWeb.clip;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.chldbwls.spring.gameWeb.clip.service.ClipService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/clip")
public class ClipRestController {

	private ClipService clipService;
	
	private ClipRestController(ClipService clipService) {
		this.clipService = clipService;
	}
	
	@PostMapping("/create")
	public Map<String, String> createClip(
			@RequestParam("title") String title
			, @RequestParam("videoPath") MultipartFile file
			, HttpSession session) {
		
		int userId = (Integer) session.getAttribute("userId");
		Map<String, String> resultMap = new HashMap<>();
		if(clipService.addClip(userId, title, file)) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		return resultMap;
	}
	
}
