package com.koreanstudy.adverb;

import org.springframework.data.jpa.repository.JpaRepository;

import com.koreanstudy.adjective.Adjective;
import com.koreanstudy.food.Word;

public interface AdverbRepository extends JpaRepository<Adverb, Long> {
}
