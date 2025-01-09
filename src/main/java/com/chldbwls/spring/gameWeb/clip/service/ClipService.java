package com.chldbwls.spring.gameWeb.clip.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.chldbwls.spring.gameWeb.clip.domain.Clip;
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
				.createdAt(createdAt)
	}

}
