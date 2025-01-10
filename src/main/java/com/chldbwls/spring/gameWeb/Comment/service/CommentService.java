package com.chldbwls.spring.gameWeb.Comment.service;

import org.springframework.stereotype.Service;

import com.chldbwls.spring.gameWeb.Comment.domain.Comment;
import com.chldbwls.spring.gameWeb.Comment.repository.CommentRepository;
import com.chldbwls.spring.gameWeb.user.service.UserService;

@Service
public class CommentService {

	private CommentRepository commentRepository;
	private UserService userService;
	
	private CommentService(
			CommentRepository commentRepository
			, UserService userService) {
		this.commentRepository = commentRepository;
		this.userService = userService;
	}
	
	// 댓글 추가
	public boolean addComment(
			int clipId
			, String contents
			, int userId) {
		
		Comment comment = Comment.builder()
				.clipId(clipId)
				.contents(contents)
				.userId(userId)
				.build();
		
		try {
			commentRepository.save(comment);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	
}
