package com.chldbwls.spring.gameWeb.Comment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chldbwls.spring.gameWeb.Comment.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer>{

	public List<Comment> findByClipId(int clipId);
}
