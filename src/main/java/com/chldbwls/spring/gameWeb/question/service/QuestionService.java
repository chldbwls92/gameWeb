package com.chldbwls.spring.gameWeb.question.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.chldbwls.spring.gameWeb.Answer.domain.Answer;
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
	
	
	// 문의사항 + 답변 모두 가져오는 리스트
	public List<QuestionDTO> getQuestionList() {
		
		List<Question> questionList = questionRepository.findAllByOrderByIdDesc();
		
		List<QuestionDTO> questionDTOList = new ArrayList<>();
		for(Question question:questionList) {
			
			int userId = question.getUserId();
			User user = userService.getUserById(userId);
			
			// 해당 문의사항(question.getId)에 대한 답변 가져오기
			List<Answer> answerList = answerService.getAnswerList(question.getId());
			
			QuestionDTO result = QuestionDTO.builder()
					.questionId(question.getId())
					.userId(userId)
					.loginId(user.getLoginId())
					.contents(question.getContents())
					.answerList(answerList)
					.build();
			
			questionDTOList.add(result);
		}
		return questionDTOList;
	}
	
	// 문의사항 삭제
	public boolean deleteQuestion(int id) {
		
		// id로 문의사항 가져오기
		Optional<Question> optionalQuestion = questionRepository.findById(id);
		
		if(optionalQuestion.isPresent()) {
			Question question = optionalQuestion.get();
			questionRepository.delete(question);
			return true;
		} else {
			return false;
		}
		
	}

}
