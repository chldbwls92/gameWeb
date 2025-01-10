package com.chldbwls.spring.gameWeb.game.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chldbwls.spring.gameWeb.game.domain.Game;

public interface OpRepository extends JpaRepository<Game, Integer>{

	public Game findAllById(int id);
}
