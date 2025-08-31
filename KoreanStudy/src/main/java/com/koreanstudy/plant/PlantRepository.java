package com.koreanstudy.plant;

import org.springframework.data.jpa.repository.JpaRepository;

import com.koreanstudy.food.Word;

public interface PlantRepository extends JpaRepository<Plant, Long> {
}
