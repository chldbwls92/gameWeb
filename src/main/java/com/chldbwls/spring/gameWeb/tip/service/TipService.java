package com.chldbwls.spring.gameWeb.tip.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.chldbwls.spring.gameWeb.like.service.LikeService;
import com.chldbwls.spring.gameWeb.tip.domain.Tip;
import com.chldbwls.spring.gameWeb.tip.dto.TipDTO;
import com.chldbwls.spring.gameWeb.tip.repository.TipRepository;
import com.chldbwls.spring.gameWeb.user.domain.User;
import com.chldbwls.spring.gameWeb.user.service.UserService;

@Service
public class TipService {
	
	private TipRepository tipRepository;
	private UserService userService;
	private LikeService likeService;
	
	
	private TipService(
			TipRepository tipRepository
			, UserService userService
			, LikeService likeService) {
		this.tipRepository = tipRepository;
		this.userService = userService;
		this.likeService = likeService;
	}
	
	
	// 팁 추가
	public boolean addTip(
			int gameId
			, int userId
			, String contents) {
	
		
		Tip tip = Tip.builder()
		.gameId(gameId)
		.userId(userId)
		.contents(contents)
		.build();
		
		try {
			tipRepository.save(tip);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	// 팁 리스트 다 가져오기
	public List<TipDTO> getTipList(int gameId, int loginUserId) {
		
		// 특정 게임 id에 해당하는 팁을 id 내림차순으로 가져오기
		List<Tip> tipList = tipRepository.findByGameIdOrderByIdDesc(gameId);
		
		List<TipDTO> tipDTOList = new ArrayList<>();
		
		for(Tip tip:tipList) {
			
			// 리뷰 작성자 정보
			int userId = tip.getUserId();
			User user = userService.getUserById(userId);
			
			// 팁 좋아요 수
			// 타켓 이름을 tip table이기 때문에 tip으로 고정
			int likeCount = likeService.getLikeCount("Tip", tip.getId());
			
			// 로그인한 사용자가 해당 리뷰에 좋아요를 눌렀는지 여부
			boolean isLike = likeService.isLike("Tip", tip.getId(), loginUserId);
			
			TipDTO tipDTO = TipDTO.builder()
					.id(tip.getId())
					.gameId(gameId)
					.userId(userId)
					.loginId(user.getLoginId())
					.contents(tip.getContents())
					.createdAt(tip.getCreatedAt())
					.likeCount(likeCount)
					.isLike(isLike)
					.build();
			
			tipDTOList.add(tipDTO);
		}
		return tipDTOList;
	}
	

}
