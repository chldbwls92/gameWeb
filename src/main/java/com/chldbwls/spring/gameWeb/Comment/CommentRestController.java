package com.chldbwls.spring.gameWeb.Comment;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chldbwls.spring.gameWeb.Comment.service.CommentService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/comment")
public class CommentRestController {
	
	private CommentService commentService;
	
	private CommentRestController(CommentService commentService) {
		this.commentService = commentService;
	}
	
	// 댓글 만들기
	@PostMapping("/create")
	public Map<String, String> createComment(
			@RequestParam("clipId") int clipId
			, @RequestParam("contents") String contents
			, HttpSession session) {
			
		// 댓글 단 사용자의 아이디 가져오기
		int userId = (Integer)session.getAttribute("userId");
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(commentService.addComment(clipId, contents, userId)) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("reuslt", "fail");
		}
		return resultMap;
	}

}
