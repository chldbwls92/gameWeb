package com.chldbwls.spring.gameWeb.like.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chldbwls.spring.gameWeb.review.domain.Review;

public interface LikeRepository extends JpaRepository<Review, Integer> {

}
