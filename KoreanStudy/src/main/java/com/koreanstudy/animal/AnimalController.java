package com.koreanstudy.animal;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/animals")
public class AnimalController {
	
private final AnimalService animalService;

public AnimalController(AnimalService animalService) {
	this.animalService = animalService;
}

@GetMapping
public List<Animal> getAllWords(){
	return animalService.findAllWords();
}
}
