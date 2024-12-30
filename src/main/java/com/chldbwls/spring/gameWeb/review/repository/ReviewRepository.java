package com.chldbwls.spring.gameWeb.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chldbwls.spring.gameWeb.review.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
