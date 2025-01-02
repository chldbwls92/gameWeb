package com.chldbwls.spring.gameWeb.user;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chldbwls.spring.gameWeb.user.domain.User;
import com.chldbwls.spring.gameWeb.user.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserRestController {
	
	private UserService userService;
	
	public UserRestController(UserService userService) {
		this.userService = userService;
	}
	
	// 회원가입
	@PostMapping("/join")
	public Map<String, String> join(
			@RequestParam("loginId") String loginId
			, @RequestParam("password") String password
			, @RequestParam("name") String name
			, @RequestParam("birthday") LocalDate birthday) {
		
		

		Map<String, String> resultMap = new HashMap<>();
		
		if(userService.addUser(loginId, password, name, birthday)) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	
	// id 중복확인
	@GetMapping("/duplicate-id")
	public Map<String, Boolean> duplicateId(@RequestParam("loginId") String loginId) {
		
		Map<String, Boolean> resultMap = new HashMap<>();
		// 중복이면 true, 아니면 false return
		resultMap.put("duplicate", userService.duplicateId(loginId));
		
		return resultMap;
	}
	
	
	//login
	@PostMapping("/login")
	public Map<String,String> login(
			@RequestParam("loginId") String loginId
			, @RequestParam("password") String password
			, HttpServletRequest request) {
		
		// 실제로 이 사람이 있는지 확인하기
		User user = userService.getUser(loginId, password);
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(user != null) {
			// 성공했을 경우
			// 사용자 정보 가져오기
			HttpSession session = request.getSession();
			
			// 로그인한 사용자 정보 저장
			session.setAttribute("userId", user.getId()); // 사용자 프라이머리키
			session.setAttribute("userLoginId", user.getLoginId()); // 사용자 로그인아이디
			
			resultMap.put("result", "success");
		} else {
			resultMap.put("result","fail");
		}
		return resultMap;
	}
	
	
}
