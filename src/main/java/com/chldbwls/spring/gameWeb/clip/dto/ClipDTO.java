package com.chldbwls.spring.gameWeb.clip.dto;


import java.time.LocalDateTime;
import java.util.List;

import com.chldbwls.spring.gameWeb.Comment.domain.Comment;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ClipDTO {
	
	private int id;
	
	// 클립 내용
	private String title;
	private String videoPath;
	private int userId;
	private String loginId;
	private LocalDateTime createdAt;
	
	// 좋아요
	private int likeCount;
	private boolean isLike;
	
	// 댓글
	private List<Comment> commentList;
}
