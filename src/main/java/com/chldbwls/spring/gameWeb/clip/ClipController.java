package com.chldbwls.spring.gameWeb.clip;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chldbwls.spring.gameWeb.clip.dto.ClipDTO;
import com.chldbwls.spring.gameWeb.clip.service.ClipService;

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

}
