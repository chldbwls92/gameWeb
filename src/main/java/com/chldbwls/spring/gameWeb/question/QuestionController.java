package com.chldbwls.spring.gameWeb.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chldbwls.spring.gameWeb.question.domain.Question;
import com.chldbwls.spring.gameWeb.question.service.QuestionService;

@Controller
@RequestMapping("/question")
public class QuestionController {
	
	private QuestionService questionService;
	
	private QuestionController(QuestionService questionService) {
		this.questionService = questionService;
	}
	
	// 문의사항 메인뷰
	@GetMapping("/main-view")
	public String main(Model model) {
		
		List<Question> questionList = questionService.getAllQuestion();
		model.addAttribute("questionList", questionList);
		return "question/main";
	}
	
	// 문의사항 작성뷰
	@GetMapping("/create-view")
	public String questionCreate() {
		return "question/create";
	}

}
