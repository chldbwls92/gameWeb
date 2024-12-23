package com.chldbwls.spring.gameWeb.user.domain;

import java.time.LocalDate;
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
@Table(name="`user`")
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //펄시스턴스
	private int id;
	
	@Column(name="loginId")
	private String loginId;
	private String password;
	private String name;
	private LocalDate birthday;
	
	@Column(name="createdAt")
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column(name="updatedAt")
	@UpdateTimestamp
	private LocalDateTime updatedAt;

}
