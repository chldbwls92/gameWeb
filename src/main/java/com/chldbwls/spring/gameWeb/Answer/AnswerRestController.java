package com.chldbwls.spring.gameWeb.Answer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chldbwls.spring.gameWeb.Answer.service.AnswerService;

@RestController
@RequestMapping("/answer")
public class AnswerRestController {
	
	private AnswerService answerService;
	
	private AnswerRestController(AnswerService answerService) {
		this.answerService = answerService;
	}
	
	// 문의사항 답변작성
	@PostMapping("/create")
	public Map<String, String> createAnswer(
			@RequestParam("questionId") int questionId
			, @RequestParam("contents") String contents) {
		
		Map<String, String> resultMap = new HashMap<>();
		if(answerService.addAnswer(questionId, contents)) {
			resultMap.put("reuslt", "success");
		} else {
			resultMap.put("result", "fail");
		}
		return resultMap;
	}

	
}
