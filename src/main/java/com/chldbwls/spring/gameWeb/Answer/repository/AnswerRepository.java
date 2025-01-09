package com.chldbwls.spring.gameWeb.Answer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chldbwls.spring.gameWeb.Answer.domain.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Integer>{

	 List<Answer> findByQuestionId(int questionId);
}
