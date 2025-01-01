package com.chldbwls.spring.gameWeb.like.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chldbwls.spring.gameWeb.like.domain.Like;

public interface LikeRepository extends JpaRepository<Like, Integer> {

}
