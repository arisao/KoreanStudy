package com.koreanstudy.plant;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/plants")
public class PlantController {
	
private final PlantService plantService;

public PlantController(PlantService plantService) {
	this.plantService = plantService;
}

@GetMapping
public List<Plant> getAllWords(){
	return plantService.findAllWords();
}
}
