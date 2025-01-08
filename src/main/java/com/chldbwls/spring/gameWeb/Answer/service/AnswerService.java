package com.chldbwls.spring.gameWeb.Answer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.chldbwls.spring.gameWeb.Answer.domain.Answer;
import com.chldbwls.spring.gameWeb.Answer.repository.AnswerRepository;
import com.chldbwls.spring.gameWeb.user.service.UserService;

@Service
public class AnswerService {
	
	private AnswerRepository answerRepository;
	private UserService userService;
	
	private AnswerService(AnswerRepository answerRepository) {
		this.answerRepository = answerRepository;
	}
	
	// 답변 추가
	public boolean addAnswer(
			int questionId
			, String contents) {
		
		Answer answer = Answer.builder()
				.questionId(questionId)
				.contents(contents)
				.build();
		
		try {
			answerRepository.save(answer);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	// 모든 답변 가져오기
	public List<Answer> getAnswerList(int questionId) {
		
		List<Answer> answerList = new ArrayList<>();
		
	}
	

}
