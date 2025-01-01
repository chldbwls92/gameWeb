package com.chldbwls.spring.gameWeb.review.dto;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
public class ReviewDTO {
	
	// 글 내용
	private int gameId;
	private int userId;
	private String contents;
	private int rating;
	
	// 글이 써진 시간
	private LocalDate createdAt;
	
	// 글을 쓴 사람의 닉네임
	private String loginId;
	
	// 좋아요 여부
	private int likeCount;
	private boolean isLike;

}
