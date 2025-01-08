package com.chldbwls.spring.gameWeb.question.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chldbwls.spring.gameWeb.question.domain.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

	//id로 question 내용 모두 list로 가져오기
	public List<Question> findAllByOrderByDesc();
}
