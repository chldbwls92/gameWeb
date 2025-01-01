package com.chldbwls.spring.gameWeb.review.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.chldbwls.spring.gameWeb.review.domain.Review;
import com.chldbwls.spring.gameWeb.review.repository.ReviewRepository;

@Service
public class ReviewService {
	
	private ReviewRepository reviewRepository;
	
	private ReviewService(ReviewRepository reviewRepository) {
		this.reviewRepository = reviewRepository;
	}
	
	// 리뷰 추가
	public boolean addReview(
			int gameId
			, int userId
			, String contents
			, int rating
			, LocalDate createdAt) {
		
		// localDateTime을 dateTime으로 변경
		LocalDateTime createdAtDateTime = createdAt.atStartOfDay();
		
		Review review = Review.builder()
		.gameId(gameId)
		.userId(userId)
		.contents(contents)
		.rating(rating)
		.createdAt(createdAtDateTime)
		.build();
		
		try {
			reviewRepository.save(review);
			return true;
		} catch(Exception e) {
			return false;
		}	
	}

}
