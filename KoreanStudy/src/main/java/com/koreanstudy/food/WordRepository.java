package com.koreanstudy.food;

import org.springframework.data.jpa.repository.JpaRepository;

import com.koreanstudy.food.Word;

public interface WordRepository extends JpaRepository<Word, Long> {
}
