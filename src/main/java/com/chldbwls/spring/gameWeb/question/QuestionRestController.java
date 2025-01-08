package com.chldbwls.spring.gameWeb.question;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chldbwls.spring.gameWeb.question.service.QuestionService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/question")
public class QuestionRestController {
	
	private QuestionService questionService;
	
	private QuestionRestController(QuestionService questionService) {
		this.questionService = questionService;
	}
	
	// 문의사항 추가
	@PostMapping("/create")
	public Map<String, String> createQuestion(
			@RequestParam("contents") String contents
			, HttpSession session) {
		
		int userId = (Integer)session.getAttribute("userId");
		
		Map<String,String> resultMap = new HashMap<>();
		if(questionService.addQuestion(userId, contents)) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		return resultMap;
		
	}

}
