package com.chldbwls.spring.gameWeb.review.domain;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name="`review`")
@Entity
public class Review {
	// 리뷰 domain
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //펄시스턴스
	private int id;
	
	@Column(name="userId")
	private int userId;
	
	@Column(name="gameId")
	private int gameId;
	private String contents;
	private int rating;
	
	@Column(name="createdAt")
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column(name="updatedAt")
	@UpdateTimestamp
	private LocalDateTime updatedAt;

}
