package com.koreanstudy.sport;

import org.springframework.data.jpa.repository.JpaRepository;

import com.koreanstudy.food.Word;

public interface SportRepository extends JpaRepository<Sport, Long> {
}
