package com.chldbwls.spring.gameWeb.like.service;

import org.springframework.stereotype.Service;

import com.chldbwls.spring.gameWeb.like.domain.Like;
import com.chldbwls.spring.gameWeb.like.repository.LikeRepository;

@Service
public class LikeService {

	private LikeRepository likeRepository;
	
	public LikeService(LikeRepository likeRepository) {
		this.likeRepository = likeRepository;
	}
	
	public boolean addLike(String targetName, int targetId, int userId) {
		
		Like like = Like.builder()
				.targetName(targetName)
				.targetId(targetId)
				.userId(userId)
				.build();
		
		try {
			likeRepository.save(like);
			return true;
		} catch(Exception e) {
			return false;
		}
		
	}
	
	
}
