package com.chldbwls.spring.gameWeb.clip.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.chldbwls.spring.gameWeb.clip.domain.Clip;
import com.chldbwls.spring.gameWeb.clip.dto.ClipDTO;
import com.chldbwls.spring.gameWeb.clip.repository.ClipRepository;
import com.chldbwls.spring.gameWeb.common.VideoManager;

@Service
public class ClipService {
	
	private ClipRepository clipRepository;
	
	private ClipService(ClipRepository clipRepository) {
		this.clipRepository = clipRepository;
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
	
	
	
	// 특정 clip의 한 화면
	public List<ClipDTO> getClipList(int clipId, int loginUserId) {
		
		List<ClipDTO> clipDTOList = new ArrayList<>();
		
		for()
	}
	
	
}
