package com.koreanstudy.adjective;

import org.springframework.data.jpa.repository.JpaRepository;

import com.koreanstudy.food.Word;

public interface AdjectiveRepository extends JpaRepository<Adjective, Long> {
}
