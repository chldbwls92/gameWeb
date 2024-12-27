package com.chldbwls.spring.gameWeb.question;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/question")
public class QuestionController {
	
	@GetMapping("/main-view")
	public String main() {
		return "question/main";
	}

}
