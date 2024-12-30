package com.chldbwls.spring.gameWeb.game;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.chldbwls.spring.gameWeb.common.FileManager;
import com.chldbwls.spring.gameWeb.game.service.OpService;

@RestController
@RequestMapping("/game")
public class OpRestController {
	// 운영자 api controller
	
	private OpService opService;
	
	public OpRestController(OpService opService) {
		this.opService = opService;
	}
	
	
	// game 추가
	@PostMapping("/create")
	public Map<String, String> createGame(
			@RequestParam("title") String title
			, @RequestParam("imagePath") MultipartFile imagePath) {
		
		// 파일 저장
		String filePath = FileManager.saveFile(imagePath);
		
		Map<String, String> resultMap = new HashMap<>();
		if(opService.addGame(title, filePath)) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		return resultMap;
	}
	
	
	// game 삭제
	@DeleteMapping("/delete")
	public Map<String, String> deleteGame(@RequestParam("id") int id) {
		
		Map<String, String> resultMap = new HashMap<>();
		if(opService.deleteGame(id)) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		return resultMap;
	}


}
