package com.chldbwls.spring.gameWeb.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chldbwls.spring.gameWeb.user.domain.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	// 중복id 찾기 true, false로 return
	public boolean existsByLoginId(String loginId);
	
	public User findByloginIdAndPassword(String loginId, String password);
	
}
