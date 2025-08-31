package com.koreanstudy.animal;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AnimalService {
private final AnimalRepository animalRepository;

public AnimalService(AnimalRepository animalRepository) {
	this.animalRepository = animalRepository;
}

public List<Animal> findAllWords(){
	return animalRepository.findAll();
}

}
