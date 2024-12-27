package com.chldbwls.spring.gameWeb.game.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chldbwls.spring.gameWeb.game.domain.Game;

public interface OpRepository extends JpaRepository<Game, Integer>{

	public List<Game> findAllByid(int id);
}
