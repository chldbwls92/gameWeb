package com.chldbwls.spring.gameWeb.my;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/my")
public class MyController {
	
	@GetMapping("/main-view")
	public String myMain() {
		return "my/main";
	}
	
	@GetMapping("/detail-view")
	public String myDetail() {
		return "my/detail";
	}

}
