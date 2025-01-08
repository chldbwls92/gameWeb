package com.chldbwls.spring.gameWeb.question.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chldbwls.spring.gameWeb.question.domain.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

	
}
