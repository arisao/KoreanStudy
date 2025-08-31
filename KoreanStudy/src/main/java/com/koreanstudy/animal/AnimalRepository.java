package com.koreanstudy.animal;

import org.springframework.data.jpa.repository.JpaRepository;

import com.koreanstudy.food.Word;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
