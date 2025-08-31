package com.koreanstudy.sport;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sports")
public class SportController {
	
private final SportService sportService;

public SportController(SportService sportService) {
	this.sportService = sportService;
}

@GetMapping
public List<Sport> getAllWords(){
	return sportService.findAllWords();
}
}
