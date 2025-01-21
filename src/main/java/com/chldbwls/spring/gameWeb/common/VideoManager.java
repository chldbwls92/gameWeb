package com.chldbwls.spring.gameWeb.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public class VideoManager {
// 동영상 관리
	
	// 동영상 파일 기본 저장 경로
	public final static String FILE_UPLOAD_PATH = "/home/ec2-user/upload/gameWeb/videoManager";
	
	// 동영상 파일 저장
	public static String saveVideo(int userId, MultipartFile file) {
		
		// 사용자별 디렉토리 경로 생성
        String directoryName = "/" + userId + "_" + System.currentTimeMillis();
        String directoryPath = FILE_UPLOAD_PATH + directoryName;

        File directory = new File(directoryPath);

        if (!directory.mkdirs()) {
            // 디렉토리 생성 실패
            return null;
        }

        // 동영상 파일 저장 경로 설정
        String filePath = directoryPath + "/" + file.getOriginalFilename();

        try {
            // 동영상 파일 저장
            byte[] bytes = file.getBytes();
            Path path = Paths.get(filePath);
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
            return null; // 파일 저장 실패
        }
        
        
        // C:\\gameProject\\videoUpload/1_1264325543/test.mp4
        // /videos/1_1264325543/test.mp4
        return "/videos" + directoryName + "/" + file.getOriginalFilename();
	}
	
	
}
