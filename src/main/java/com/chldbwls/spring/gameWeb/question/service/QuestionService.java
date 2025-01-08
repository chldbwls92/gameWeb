package com.chldbwls.spring.gameWeb.question.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.chldbwls.spring.gameWeb.Answer.service.AnswerService;
import com.chldbwls.spring.gameWeb.question.domain.Question;
import com.chldbwls.spring.gameWeb.question.dto.QuestionDTO;
import com.chldbwls.spring.gameWeb.question.repository.QuestionRepository;
import com.chldbwls.spring.gameWeb.user.domain.User;
import com.chldbwls.spring.gameWeb.user.service.UserService;

@Service
public class QuestionService {
	
	private QuestionRepository questionRepository;
	private AnswerService answerService;
	private UserService userService;
	
	private QuestionService(
			QuestionRepository questionRepository
			, AnswerService answerService
			, UserService userService) {
		this.questionRepository = questionRepository;
		this.answerService = answerService;
		this.userService = userService;
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
//	public List<Question> getAllQuestion() {
//		List<Question> questionList = questionRepository.findAll();
//		return questionList;
//	}
	
	
	// 문의사항 + 답변 모두 가져오는 리스트
	public List<QuestionDTO> getQuestionList() {
		
		List<Question> questionList = questionRepository.findAllByOrderByDesc();
		
		List<QuestionDTO> questionDTOList = new ArrayList<>();
		for(Question question:questionList) {
			
			int userId = question.getUserId();
			User user = userService.getUserById(userId);
			
			List<Answer> answerList = 
			
		}
		
	}

}
