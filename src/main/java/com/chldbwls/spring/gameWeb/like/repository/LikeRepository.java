package com.chldbwls.spring.gameWeb.like.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chldbwls.spring.gameWeb.like.domain.Like;

public interface LikeRepository extends JpaRepository<Like, Integer> {

	// user가 좋아요를 눌렀는지 안 눌렀는지
	public int countByTargetNameAndTargetIdAndUserId(String targetName, int targetId, int userId);
	
	// 타겟이름과 아이디로 하나의 타겟 아이디에 전체좋아요 몇개인지 count
	public int countByTargetNameAndTargetId(String targetName, int targetId);
	
	// deleteLike
	public Optional<Like> findByTargetNameAndTargetIdAndUserId(String targetName, int targetId, int userId);
	
}
