package com.chldbwls.spring.gameWeb.user.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.chldbwls.spring.gameWeb.common.MD5HashingEncoder;
import com.chldbwls.spring.gameWeb.user.domain.User;
import com.chldbwls.spring.gameWeb.user.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;
	
	private UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	// user 추가하기
	public boolean addUser(
			String loginId
			, String password
			, String name
			, LocalDate birthday) {
		
		// 비밀번호 암호화
		String encodingPassword = MD5HashingEncoder.encode(password);
		
		User user = User.builder()
		.loginId(loginId)
		.password(encodingPassword)
		.name(name)
		.birthday(birthday)
		.build();
		
		try {
			userRepository.save(user);
			return true;
		} catch(Exception e) {
			return false;
		}	
	}
	
	
	// 아이디 중복확인
	public boolean duplicateId(String loginId) {
		return userRepository.existsByLoginId(loginId);
	}
	
	
	// 특정 이용자 있는지 확인
	public User getUser(String loginId, String password) {
		
		// 비밀번호 암호화 된 거 가져오기
		String encodingPassword = MD5HashingEncoder.encode(password);
		return userRepository.findByloginIdAndPassword(loginId, encodingPassword);
	}
	
	
	// id로 유저 알아오기
	public User getUserById(int id) {
		 Optional<User> optionalUser = userRepository.findById(id);
		 return optionalUser.get();	
	}
	

}
