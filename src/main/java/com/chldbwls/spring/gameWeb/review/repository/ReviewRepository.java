package com.chldbwls.spring.gameWeb.review.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chldbwls.spring.gameWeb.review.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

	// 테이블(review)의 모든 데이터 조회, id기준으로 내림차순
	List<Review> findByGameIdOrderByIdDesc(int gameId);
}
