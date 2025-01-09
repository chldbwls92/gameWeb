package com.chldbwls.spring.gameWeb.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chldbwls.spring.gameWeb.question.dto.QuestionDTO;
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
		
		List<QuestionDTO> questionList = questionService.getQuestionList();
		
		model.addAttribute("questionList", questionList);
		return "question/main";
	}
	
	// 문의사항 작성뷰
	@GetMapping("/create-view")
	public String questionCreate() {
		return "question/create";
	}
	
	// 문의사항 운영자 뷰
	@GetMapping("/op-view")
	public String questionOp(Model model) {
		List<QuestionDTO> questionList = questionService.getQuestionList();
		
		model.addAttribute("questionList", questionList);
		return "question/op";
	}
	
	

}
