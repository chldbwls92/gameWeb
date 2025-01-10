package com.chldbwls.spring.gameWeb.clip.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chldbwls.spring.gameWeb.clip.domain.Clip;

public interface ClipRepository extends JpaRepository<Clip, Integer> {

	public Clip findAllById(int id);
}
