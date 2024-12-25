package com.chldbwls.spring.gameWeb.game;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.chldbwls.spring.gameWeb.common.FileManager;
import com.chldbwls.spring.gameWeb.game.service.OpService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/game")
public class OpRestController {
	// 운영자 api controller
	
	private OpService opService;
	
	public OpRestController(OpService opService) {
		this.opService = opService;
	}
	
	
	// game 추가
	public Map<String, String> createGame(
			@RequestParam("title") String title
			, @RequestParam("imagePath") MultipartFile imagePath
			, HttpSession session) {
		
		// userLoginId를 가져와서 판단.. 할 필요가 없나 ..?
		// 짯피 맞지 않으면 화면 자체를 안 보이게 할 거니까
		String userLoginId = (String)session.getAttribute("userLoginId");
		
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


}
