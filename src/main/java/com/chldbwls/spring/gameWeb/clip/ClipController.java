package com.chldbwls.spring.gameWeb.clip;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chldbwls.spring.gameWeb.clip.domain.Clip;
import com.chldbwls.spring.gameWeb.clip.dto.ClipDTO;
import com.chldbwls.spring.gameWeb.clip.service.ClipService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/clip")
public class ClipController {
	
	private ClipService clipService;
	
	private ClipController(ClipService clipService) {
		this.clipService = clipService;
	}
	
	// 클립 메인뷰
	@GetMapping("/main-view")
	public String clipMain(Model model) {
		
		List<ClipDTO> clipList = clipService.getAllClips();
		
		model.addAttribute("clipList", clipList);
		return "clip/main";
	}
	
	@GetMapping("/create-view")
	public String clipCreate() {
		return "clip/create";
	}
	
	@GetMapping("/datail-view")
	public String clipDetail(
			@RequestParam("clipId") int clipId
			, Model model
			, HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId");
		
		List<ClipDTO> clipList = clipService.getClip(clipId);
		model.addAttribute("clipList", clipList);
		
		return "clip/detail";
	}

}
