package com.chldbwls.spring.gameWeb.question.dto;

import java.util.List;

import com.chldbwls.spring.gameWeb.Answer.domain.Answer;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class QuestionDTO {
	
	private int id;
	
	private int userId;
	private String loginId;
	
	private List<Answer> answerList;

}
