package com.chldbwls.spring.gameWeb.common;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

import org.springframework.web.multipart.MultipartFile;

public class FileManager {
	
	public final static String FILE_UPLOAD_PATH = "C:\\gameWeb\\upload";
	
	public static String saveFile(MultipartFile file) {
		
		if(file == null) {
			return null;
		}
	
		 // 파일 저장 경로 설정
        String filePath = FILE_UPLOAD_PATH + "/" + file.getOriginalFilename();

        try {
            // 파일 저장
            Path path = Paths.get(filePath);
            Files.write(path, file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        //C:\\gameWeb\\upload/LeagueOfLegends.jpg
        // /game/LeagueOfLegends.jpg
        // 저장된 파일의 경로 반환
        return "/game/" + file.getOriginalFilename();
    }


}
