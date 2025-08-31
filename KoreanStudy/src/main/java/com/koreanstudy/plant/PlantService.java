package com.koreanstudy.plant;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PlantService {
private final PlantRepository plantRepository;

public PlantService(PlantRepository plantRepository) {
	this.plantRepository = plantRepository;
}

public List<Plant> findAllWords(){
	return plantRepository.findAll();
}

}
