package com.chldbwls.spring.gameWeb.tip.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chldbwls.spring.gameWeb.tip.domain.Tip;

public interface TipRepository extends JpaRepository<Tip, Integer> {

}
