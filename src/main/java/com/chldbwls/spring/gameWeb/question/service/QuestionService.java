package com.chldbwls.spring.gameWeb.question.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chldbwls.spring.gameWeb.question.domain.Question;
import com.chldbwls.spring.gameWeb.question.repository.QuestionRepository;

@Service
public class QuestionService {
	
	private QuestionRepository questionRepository;
	
	private QuestionService(QuestionRepository questionRepository) {
		this.questionRepository = questionRepository;
	}
	
	// 문의사항 추가
	public boolean addQuestion(
			int userId
			, String contents) {
		
		Question question = Question.builder()
				.userId(userId)
				.contents(contents)
				.build();
		
		try {
			questionRepository.save(question);
			return true;
		} catch(Exception e) {
			return false;
		}		
	}
	
	// 모든 문의사항 list 가져오기
	public List<Question> getAllQuestion() {
		List<Question> questionList = questionRepository.findAll();
		return questionList;
	}

}
