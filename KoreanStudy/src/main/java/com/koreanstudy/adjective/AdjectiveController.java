package com.koreanstudy.adjective;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/adjectives")
public class AdjectiveController {
	
private final AdjectiveService adjectiveService;

public AdjectiveController(AdjectiveService adjectiveService) {
	this.adjectiveService = adjectiveService;
}

@GetMapping
public List<Adjective> getAllWords(){
	return adjectiveService.findAllWords();
}
}
