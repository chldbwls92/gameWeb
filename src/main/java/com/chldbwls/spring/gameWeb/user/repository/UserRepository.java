package com.chldbwls.spring.gameWeb.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chldbwls.spring.gameWeb.user.domain.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
