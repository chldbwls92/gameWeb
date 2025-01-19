package com.chldbwls.spring.gameWeb.clip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chldbwls.spring.gameWeb.clip.domain.Clip;

public interface ClipRepository extends JpaRepository<Clip, Integer> {

	// 클립 하나
	public Clip findAllById(int id);
	
	// 모든 클립
	public List<Clip> findAllByOrderByIdDesc();
}
