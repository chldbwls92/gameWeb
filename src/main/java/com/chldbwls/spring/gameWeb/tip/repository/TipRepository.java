package com.chldbwls.spring.gameWeb.tip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chldbwls.spring.gameWeb.tip.domain.Tip;

public interface TipRepository extends JpaRepository<Tip, Integer> {
	
	// 테이블(tip)의 모든 데이터 조회, id 기준으로 내림차순
	public List<Tip> findByGameIdOrderByIdDesc(int gameId);
	
	// gameId로 모든 팁 가져오기
	public List<Tip> findByGameId(int gameId);

}
