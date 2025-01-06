package com.chldbwls.spring.gameWeb.tip.dto;

import java.time.LocalDateTime;

import com.chldbwls.spring.gameWeb.review.dto.ReviewDTO;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TipDTO {
	
	// tip primary key
	private int id;
	
	// 글 내용
	private int gameId;
	private int userId;
	private String contents;
	
	// 팁 작성된 시간
	private LocalDateTime createdAt;
	
	// 글 작성한 사람의 로그인아이디
	private String loginId;
	
	// 좋아요
	private int likeCount;
	private boolean isLike;

}
