package com.chldbwls.spring.gameWeb.clip.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.chldbwls.spring.gameWeb.clip.domain.Clip;
import com.chldbwls.spring.gameWeb.clip.dto.ClipDTO;
import com.chldbwls.spring.gameWeb.clip.repository.ClipRepository;
import com.chldbwls.spring.gameWeb.common.VideoManager;
import com.chldbwls.spring.gameWeb.like.service.LikeService;
import com.chldbwls.spring.gameWeb.user.domain.User;
import com.chldbwls.spring.gameWeb.user.service.UserService;

@Service
public class ClipService {
	
	private ClipRepository clipRepository;
	private LikeService likeService;
	private UserService userService;
	
	private ClipService(
			ClipRepository clipRepository
			, LikeService likeService
			, UserService userService) {
		this.clipRepository = clipRepository;
		this.likeService = likeService;
		this.userService = userService;
	}
	
	// 클립 추가
	public boolean addClip(int userId, String title, MultipartFile file) {
		
		// 비디오 경로
		String videoPath = VideoManager.saveVideo(userId, file);
		
		Clip clip = Clip.builder()
				.userId(userId)
				.title(title)
				.videoPath(videoPath)
				.build();
		
		try {
			clipRepository.save(clip);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	// 특정 클립 하나의 모든 정보 가져오기
	public ClipDTO getClip(int clipId) {
		
		// 클립 한개 정보 가져오기
		Optional<Clip> clipList = clipRepository.findById(clipId);
		
	    // 클립이 존재하지 않을 경우 null 반환 (또는 예외 처리)
	    if (clipList.isEmpty()) {
	        return null; // 또는 적절한 에러 처리 로직 추가
	    }
	    
	    Clip clip = clipList.get();
		
	    User user = userService.getUserById(clip.getUserId());

	    // 클립 좋아요 수
	    int likeCount = likeService.getLikeCount("Clip", clip.getId());

	    return ClipDTO.builder()
	            .id(clip.getId())
	            .title(clip.getTitle())
	            .videoPath(clip.getVideoPath())
	            .userId(clip.getUserId())
	            .loginId(user.getLoginId())
	            .likeCount(likeCount)
	            .createdAt(clip.getCreatedAt())
	            .build();
	}
	
	// 모든 클립 보이게
	public List<ClipDTO> getAllClips() {
		List<Clip> clipList = clipRepository.findAllByOrderByIdDesc();
		List<ClipDTO> clipDTOList = new ArrayList<>();
		
		for(Clip clip : clipList) {
			User user = userService.getUserById(clip.getUserId());
			
			// 리뷰 좋아요 수
			// 타겟이름을 review table이기 때문에 review로 고정
			int likeCount = likeService.getLikeCount("Clip", clip.getId());
			
			
			ClipDTO clipDTO = ClipDTO.builder()
					.id(clip.getId())
					.title(clip.getTitle())
					.videoPath(clip.getVideoPath())
					.userId(clip.getUserId())
					.loginId(user.getLoginId())
					.likeCount(likeCount)
					.createdAt(clip.getCreatedAt())
					.build();
			clipDTOList.add(clipDTO);
		}
		return clipDTOList;
	}
	

	
}
