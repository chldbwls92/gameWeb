package com.chldbwls.spring.gameWeb.like.domain;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

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
@Table(name="`like`")
@Entity
public class Like {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //펄시스턴스
	private int id;
	
	@Column(name="userId")
	private int userId;
	
	@Column(name="targetName")
	private String targetName;
	
	@Column(name="targetId")
	private int targetId;
	
	@Column(name="createdAt")
	@CreationTimestamp
	private LocalDateTime createdAt;

}
