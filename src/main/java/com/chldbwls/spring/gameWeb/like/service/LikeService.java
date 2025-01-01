package com.chldbwls.spring.gameWeb.like.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.chldbwls.spring.gameWeb.like.domain.Like;
import com.chldbwls.spring.gameWeb.like.repository.LikeRepository;

@Service
public class LikeService {

	private LikeRepository likeRepository;
	
	public LikeService(LikeRepository likeRepository) {
		this.likeRepository = likeRepository;
	}
	
	// 좋아요 추가
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
	
	// 좋아요 삭제
	public boolean deleteLike(String targetName, int targetId, int userId) {
		
		Optional<Like> optionalLike = likeRepository.findByTargetNameAndTargetIdAndUserId(targetName, targetId, userId);
		
		if(optionalLike.isPresent()) {
			Like like = optionalLike.get();
			// 있으면 삭제
			likeRepository.delete(like);
			// 삭제되었다
			return true;
		} else {
			return false;
		}
	}
	
	
	// 사용 user가 좋아요 눌렀는지 안 눌렀는지
	public boolean isLike(String targetName, int targetId, int userId) {
		int count = likeRepository.countByTargetNameAndTargetIdAndUserId(targetName, targetId, userId);
		
		if(count > 0) {
			return true;
		} else {
			return false;
		}
		
	}
	
	
	
	
	// 하나의 tip이나 review에 좋아요 몇개 달렸는지
	public int getLikeCount(String targetName, int targetId) {
		return likeRepository.countByTargetNameAndTargetId(targetName, targetId);
	}
	
	
}
