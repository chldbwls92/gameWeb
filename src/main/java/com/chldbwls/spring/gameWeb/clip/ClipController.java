package com.chldbwls.spring.gameWeb.clip;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clip")
public class ClipController {
	
	@GetMapping("/main-view")
	public String ClipMain() {
		return "clip/main";
	}

}
