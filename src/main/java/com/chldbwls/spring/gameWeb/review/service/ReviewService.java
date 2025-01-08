package com.chldbwls.spring.gameWeb.review.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.chldbwls.spring.gameWeb.like.service.LikeService;
import com.chldbwls.spring.gameWeb.review.domain.Review;
import com.chldbwls.spring.gameWeb.review.dto.ReviewDTO;
import com.chldbwls.spring.gameWeb.review.repository.ReviewRepository;
import com.chldbwls.spring.gameWeb.user.domain.User;
import com.chldbwls.spring.gameWeb.user.service.UserService;

@Service
public class ReviewService {
	
	private ReviewRepository reviewRepository;
	private UserService userService;
	private LikeService likeService;
	
	private ReviewService(
			ReviewRepository reviewRepository
			, UserService userService
			, LikeService likeService) {
		this.reviewRepository = reviewRepository;
		this.userService = userService;
		this.likeService = likeService;
	}
	
	// 리뷰 추가
	public boolean addReview(
			int gameId
			, int userId
			, String contents
			, int rating) {
		
		Review review = Review.builder()
		.gameId(gameId)
		.userId(userId)
		.contents(contents)
		.rating(rating)
		.build();
		
		try {
			reviewRepository.save(review);
			return true;
		} catch(Exception e) {
			return false;
		}	
	}
									// 조회된 리뷰마다 리뷰를 작성한 사람의 로그인id 가져오기
	public List<ReviewDTO> getReviewList(int gameId, int loginUserId) {
		
		// 특정 게임 ID에 해당하는 리뷰를 ID 내림차순으로 가져오기
		List<Review> reviewList = reviewRepository.findByGameIdOrderByIdDesc(gameId);
		
		List<ReviewDTO> reviewDTOList = new ArrayList<>();
		
		for(Review review:reviewList) {
			// 리뷰 작성자 정보
			int userId = review.getUserId();
			User user = userService.getUserById(userId);
			
			// 리뷰 좋아요 수
			// 타겟이름을 review table이기 때문에 review로 고정
			int likeCount = likeService.getLikeCount("Review", review.getId());
			
			// 로그인한 사용자가 해당 리뷰에 좋아요를 눌렀는지 여부
			boolean isLike = likeService.isLike("Review", review.getId(), loginUserId);
			
			
	        ReviewDTO reviewDTO = ReviewDTO.builder()
	        		.id(review.getId())
	                .gameId(gameId)
	                .userId(userId)
	                .loginId(user.getLoginId())
	                .contents(review.getContents())
	                .rating(review.getRating())
	                .createdAt(review.getCreatedAt())
	                .likeCount(likeCount)
	                .isLike(isLike)
	                .build();

	            reviewDTOList.add(reviewDTO);
		}
		return reviewDTOList;
	}
	
	// 각 게임에 해당되는 리뷰 평점
	public double getRatingAvgByGameId(int gameId) {
		
		// 해당 게임의 모든 리뷰 가져오기
		List<Review> reviewList = reviewRepository.findByGameId(gameId);
		
		// 리뷰가 없을 경우 0.0(double) return
		if(reviewList.isEmpty()) {
			return 0.0;
		}
		
		// 평점 다 더하기
		int result = 0;
		for(Review review : reviewList) {
			result += review.getRating();
		}
		
		// 나눈 거 return
		return (double) result / reviewList.size();
	}
	

}
