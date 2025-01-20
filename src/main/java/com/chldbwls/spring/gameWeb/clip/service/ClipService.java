package com.chldbwls.spring.gameWeb.clip.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.chldbwls.spring.gameWeb.Comment.domain.Comment;
import com.chldbwls.spring.gameWeb.Comment.service.CommentService;
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
	private CommentService commentService;
	private UserService userService;
	
	private ClipService(
			ClipRepository clipRepository
			, LikeService likeService
			, CommentService commentService
			, UserService userService) {
		this.clipRepository = clipRepository;
		this.likeService = likeService;
		this.commentService = commentService;
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
	public Clip getClip(int id) {
		Clip clip = clipRepository.findAllById(id);
		return clip;
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
	
	
	
	
	// 특정 clip의 한 화면
	public ClipDTO getClipList(int clipId, int loginUserId) {
		
		List<Clip> clipList = new ArrayList<>();
		
		

	}
	
	
}
