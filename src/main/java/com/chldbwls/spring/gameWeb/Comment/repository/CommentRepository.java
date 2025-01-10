package com.chldbwls.spring.gameWeb.Comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chldbwls.spring.gameWeb.Comment.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer>{

}
